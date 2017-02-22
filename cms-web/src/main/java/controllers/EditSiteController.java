package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.Site;
import beans.User;
import usecases.EditSiteUseCase;
import usecases.PageManagementUseCase;

@Controller
public class EditSiteController {
	private static final String REDIRECT_SITE_MANAGEMENT = "redirect:/site-management";
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String USER_SESSION_ATTRIBUTE = "user";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String PAGES_ATTRIBUTE = "pages";
	private static final String SITE_ATTRIBUTE = "site";
	private static final String EDIT_SITE_JSP = "EditSite";
	private static final String EDIT_SITE_URL = "/edit-site";
	private static final String BASE_JSP = "base";
	private static final String ROOT_URL = "/root";

	@Autowired
	private EditSiteUseCase editSiteUseCase;

	@Autowired
	private PageManagementUseCase pageManagementUseCase;

	@RequestMapping(value = EDIT_SITE_URL, method = RequestMethod.GET)
	public ModelAndView editSite(HttpServletRequest req, HttpServletResponse resp, @RequestParam String uri) {
		if (ROOT_URL.equals(uri)) {
			return new ModelAndView(REDIRECT_SITE_MANAGEMENT);
		}

		req.setAttribute(CURRENT_USER_ATTRIBUTE, (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE));
		req.setAttribute(SITE_ATTRIBUTE, editSiteUseCase.getSiteByUri(uri));
		req.setAttribute(PAGES_ATTRIBUTE, pageManagementUseCase.getAllPages());
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, EDIT_SITE_JSP);

		return new ModelAndView(BASE_JSP);
	}

	@RequestMapping(value = EDIT_SITE_URL, method = RequestMethod.POST)
	public ModelAndView editSite(HttpServletRequest req, HttpServletResponse resp, @RequestParam String uri,
			@RequestParam String name, @RequestParam String landingPage) {

		Site site = editSiteUseCase.getSiteByUri(uri);
		site.setName(name);
		site.setLandingPage(pageManagementUseCase.getPageByUri(landingPage));
		editSiteUseCase.updateSite(site);

		return new ModelAndView(REDIRECT_SITE_MANAGEMENT);
	}
}
