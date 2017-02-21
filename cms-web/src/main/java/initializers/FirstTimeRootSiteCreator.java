package initializers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import beans.PageBuilder;
import beans.SiteBuilder;
import entities.PageEntity;
import entities.SiteEntity;
import persistence.PageRepository;
import persistence.SiteRepository;
import utils.CopyUtil;

public class FirstTimeRootSiteCreator extends AbstractInitializer<SiteRepository> {
	private static final String WELCOME_TITLE = "Welcome";
	private static final String WELCOME_URI = "/welcome";
	private static final String ROOT_NAME = "Root";
	private static final String ROOT_URI = "/root";

	@Autowired
	private PageRepository pageRepository;

	@Override
	public void initialize() {
		if (Objects.isNull(repository.findByUri(ROOT_URI))) {
			SiteEntity root = CopyUtil.createAndCopyFields(SiteEntity.class,
					new SiteBuilder().setName(ROOT_NAME).setUri(ROOT_URI).build());
			repository.save(root);

			PageEntity welcome = CopyUtil.createAndCopyFields(PageEntity.class,
					new PageBuilder().setTitle(WELCOME_TITLE).setUri(WELCOME_URI).build());
			pageRepository.save(welcome);

			root.setLandingPage(welcome);
			welcome.setSite(root);
			repository.save(root);
			pageRepository.save(welcome);
		}
	}
}
