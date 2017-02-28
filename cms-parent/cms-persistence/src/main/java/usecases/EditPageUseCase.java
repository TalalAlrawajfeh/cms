package usecases;

import org.springframework.beans.factory.annotation.Autowired;

import persistence.PageRepository;

public class EditPageUseCase {
	@Autowired
	private PageRepository pageRepository;

	public void deletePageByUri(String uri) {
		pageRepository.delete(pageRepository.findByUri(uri));
	}
}
