package usecases;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Page;
import entities.PageEntity;
import persistence.PageRepository;
import utils.EntityCopyUtil;

public class AddPageUseCase {
	@Autowired
	private PageRepository pageRepository;

	public void savePage(Page page) {
		pageRepository.save(EntityCopyUtil.createAndCopyFields(PageEntity.class, page));
	}
}
