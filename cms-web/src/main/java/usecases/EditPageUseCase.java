package usecases;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Page;
import persistence.PageRepository;

public class EditPageUseCase {
	private static final String URI_SEPERATOR = "/";

	@Autowired
	private PageRepository pageRepository;

	public void deletePageByUri(String uri) {
		pageRepository.delete(pageRepository.findByUri(uri));
	}

	public String getPagePureUri(Page page) {
		return page.getUri().substring(page.getUri().lastIndexOf(URI_SEPERATOR));
	}
}
