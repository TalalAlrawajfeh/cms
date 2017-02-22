package utils;

import beans.Site;
import entities.PageEntity;
import entities.SiteEntity;

public class Test {
	public static void main(String[] args) {
		SiteEntity root = new SiteEntity();
		root.setName("ROOT");
		root.setUri("/root");

		PageEntity welcomeLandingPage = new PageEntity();
		welcomeLandingPage.setSite(root);
		welcomeLandingPage.setTitle("Welcome");
		welcomeLandingPage.setUri("/welcome");
		root.setLandingPage(welcomeLandingPage);

		SiteEntity site = new SiteEntity();
		site.setParentSite(root);
		site.setName("My Site");
		site.setUri("/my-site");

		PageEntity siteLandingPage = new PageEntity();
		siteLandingPage.setSite(site);
		siteLandingPage.setTitle("My Site Landing Page");
		siteLandingPage.setUri("/my-site-landing-page");
		site.setLandingPage(siteLandingPage);
		
		Site beanReplicae = EntityCopyUtil.createAndCopyFields(Site.class, site);

		System.out.println(beanReplicae);
		System.out.println(beanReplicae.getParentSite());
		System.out.println(beanReplicae.getLandingPage());
	}
}
