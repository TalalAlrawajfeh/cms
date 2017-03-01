package usecases;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Page;
import entities.PageEntity;
import entities.PublishedPageEntity;
import entities.SiteEntity;
import persistence.PageRepository;
import persistence.PublishedPageRepository;
import utils.CopySetting;
import utils.EntityCopyUtil;

public class EditPageUseCase {
	@Autowired
	private PageRepository pageRepository;

	@Autowired
	private PublishedPageRepository publishedPageRepository;

	public void deletePageByUri(String uri) {
		pageRepository.delete(pageRepository.findByUri(uri));
	}

	public void publishPage(String uri) {
		PageEntity pageEntity = pageRepository.findByUri(uri);
		PublishedPageEntity correspondingPublishedPage = publishedPageRepository.findByCorrespondingPage(pageEntity);

		if (Objects.nonNull(correspondingPublishedPage)) {
			publishedPageRepository.delete(correspondingPublishedPage);
		}

		PublishedPageEntity publishedPage = EntityCopyUtil.createAndCopyFields(PublishedPageEntity.class, pageEntity,
				new CopySetting[] { new CopySetting(SiteEntity.class, SiteEntity.class),
						new CopySetting(PageEntity.class, PageEntity.class) });

		publishedPage.setCorrespondingPage(pageEntity);
		publishedPageRepository.save(publishedPage);

		pageEntity.setIsPublished(Boolean.valueOf(true));
		pageRepository.save(pageEntity);
	}

	public boolean wasPublished(String uri) {
		return Objects.nonNull(publishedPageRepository.findByCorrespondingPage(pageRepository.findByUri(uri)));
	}

	public Page getCorrespondingPublishedPage(Page page) {
		return EntityCopyUtil.createAndCopyFields(Page.class,
				publishedPageRepository.findByCorrespondingPage(pageRepository.findByUri(page.getUri())));
	}

	public void deleteCorrespondingPublishedPage(String uri) {
		publishedPageRepository.delete(publishedPageRepository.findByCorrespondingPage(pageRepository.findByUri(uri)));
	}
}
