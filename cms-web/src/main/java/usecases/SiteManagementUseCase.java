package usecases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Site;
import entities.SiteEntity;
import persistence.SiteRepository;
import utils.CopyUtil;

public class SiteManagementUseCase {
	@Autowired
	private SiteRepository siteRepository;

	public List<Site> getAllSites() {
		Iterator<SiteEntity> iterator = siteRepository.findAll().iterator();
		List<Site> sites = new ArrayList<>();

		while (iterator.hasNext()) {
			sites.add(CopyUtil.createAndCopyFields(Site.class, iterator.next()));
		}

		return sites;
	}
}
