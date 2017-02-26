package usecases;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Page;
import persistence.PageRepository;

public class EditPageUseCase {
	@Autowired
	private PageRepository pageRepository;

	public void deletePage(Page page) {
		pageRepository.deleteByUri(page.getUri());
	}

	public String getPagePureUri(Page page) {
		return page.getUri().substring(page.getUri().lastIndexOf("/"));
	}
}
