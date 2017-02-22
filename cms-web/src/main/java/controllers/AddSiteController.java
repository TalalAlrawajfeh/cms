package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.User;
import usecases.SiteManagementUseCase;

@Controller
public class AddSiteController {
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String SITES_ATTRIBUTE = "sites";
	private static final String ADD_SITE_JSP = "AddSite";
	private static final String ADD_SITE_URL = "/add-site";
	private static final String BASE_JSP = "base";

	@Autowired
	private SiteManagementUseCase siteManagementUseCase;

	@RequestMapping(value = ADD_SITE_URL, method = RequestMethod.GET)
	public ModelAndView addSite(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");

		req.setAttribute(CURRENT_USER_ATTRIBUTE, user);
		req.setAttribute(SITES_ATTRIBUTE, siteManagementUseCase.getAllSites());
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, ADD_SITE_JSP);

		return new ModelAndView(BASE_JSP);
	}
}
