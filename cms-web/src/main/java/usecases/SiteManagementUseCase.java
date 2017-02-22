package usecases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import beans.Site;
import persistence.SiteRepository;
import utils.CopyUtil;

public class SiteManagementUseCase {
	@Autowired
	private SiteRepository siteRepository;

	public List<Site> getAllSites() {
		return StreamSupport.stream(siteRepository.findAll().spliterator(), true)
				.map(s -> CopyUtil.createAndCopyFields(Site.class, s)).collect(Collectors.toList());
	}
}
