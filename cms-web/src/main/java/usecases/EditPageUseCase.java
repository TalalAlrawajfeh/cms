package usecases;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Page;
import entities.PageEntity;
import persistence.PageRepository;
import utils.EntityCopyUtil;

public class EditPageUseCase {
	private static final String URI_SEPERATOR = "/";
	@Autowired
	private PageRepository pageRepository;

	public void deletePage(Page page) {
		pageRepository.delete(EntityCopyUtil.createAndCopyFields(PageEntity.class, page));
	}

	public String getPagePureUri(Page page) {
		return page.getUri().substring(page.getUri().lastIndexOf(URI_SEPERATOR));
	}
}
