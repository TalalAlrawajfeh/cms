package usecases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Site;
import entities.SiteEntity;
import persistence.SiteRepository;
import utils.EntityCopyUtil;

public class SiteManagementUseCase {
	@Autowired
	private SiteRepository siteRepository;

	public List<Site> getAllSites() {
		Iterable<SiteEntity> sites = siteRepository.findAll();
		Iterator<SiteEntity> iterator = sites.iterator();
		List<Site> siteList = new ArrayList<>();
		while (iterator.hasNext()) {
			siteList.add(EntityCopyUtil.createAndCopyFields(Site.class, iterator.next()));
		}
		return siteList;
		// return StreamSupport.stream(sites.spliterator(), true)
		// .map(s -> EntityCopyUtil.createAndCopyFields(Site.class,
		// s)).collect(Collectors.toList());
	}
}
