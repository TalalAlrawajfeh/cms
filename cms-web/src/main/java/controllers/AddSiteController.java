package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.Page;
import beans.PageBuilder;
import beans.Site;
import beans.SiteBuilder;
import beans.User;
import usecases.AddPageUseCase;
import usecases.AddSiteUseCase;
import usecases.SiteManagementUseCase;

@Controller
public class AddSiteController {
	private static final String REDIRECT_SITE_MANAGEMENT = "redirect:/site-management";
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String DUPLICATE_URI_MESSAGE = "A site with the same URI exists";
	private static final String SHOW_ERROR_ATTRIBUTE = "showError";
	private static final String SITES_ATTRIBUTE = "sites";
	private static final String WELCOME_TITLE = "Welcome";
	private static final String ADD_SITE_JSP = "AddSite";
	private static final String ADD_SITE_URL = "/add-site";
	private static final String WELCOME_URI = "/welcome";
	private static final String BASE_JSP = "Base";

	@Autowired
	private SiteManagementUseCase siteManagementUseCase;

	@Autowired
	private AddSiteUseCase addSiteUseCase;

	@Autowired
	private AddPageUseCase addPageUseCase;

	@RequestMapping(value = ADD_SITE_URL, method = RequestMethod.GET)
	public ModelAndView addSite(HttpServletRequest req, HttpServletResponse resp) {
		showProperAttributes(req, false);

		return new ModelAndView(BASE_JSP);
	}

	@RequestMapping(value = ADD_SITE_URL, method = RequestMethod.POST)
	public ModelAndView addSite(HttpServletRequest req, HttpServletResponse resp, @RequestParam String name,
			@RequestParam String uri, @RequestParam String parentSite) {

		if (addSiteUseCase.siteExists(uri)) {
			showProperAttributes(req, true);

			return new ModelAndView(BASE_JSP);
		}

		createSite(name, uri, parentSite);

		return new ModelAndView(REDIRECT_SITE_MANAGEMENT);
	}

	private void createSite(String name, String uri, String parentSite) {
		Site site = new SiteBuilder().setName(name).setUri(parentSite + uri)
				.setParentSite(new SiteBuilder().setUri(parentSite).build()).build();
		addSiteUseCase.saveSite(site);

		Page page = new PageBuilder().setTitle(WELCOME_TITLE).setUri(site.getUri() + WELCOME_URI).build();
		page.setSite(site);
		addPageUseCase.savePage(page);

		site.setLandingPage(page);
		addSiteUseCase.saveSite(site);
	}

	private void showProperAttributes(HttpServletRequest req, boolean showErrorMessage) {
		req.setAttribute(CURRENT_USER_ATTRIBUTE, (User) req.getSession().getAttribute("user"));
		req.setAttribute(SITES_ATTRIBUTE, siteManagementUseCase.getAllSites());
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, ADD_SITE_JSP);
		req.setAttribute(SHOW_ERROR_ATTRIBUTE, showErrorMessage);

		if (showErrorMessage) {
			req.setAttribute(ERROR_MESSAGE_ATTRIBUTE, DUPLICATE_URI_MESSAGE);
		}
	}
}
