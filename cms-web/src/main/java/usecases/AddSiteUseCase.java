package usecases;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Site;
import entities.SiteEntity;
import persistence.SiteRepository;
import utils.CopyUtil;

public class AddSiteUseCase {
	@Autowired
	private SiteRepository siteRepository;

	public void saveSite(Site site) {
		siteRepository.save(CopyUtil.createAndCopyFields(SiteEntity.class, site));
	}

	public boolean siteExists(String uri) {
		return Objects.nonNull(siteRepository.findByUri(uri));
	}
}
