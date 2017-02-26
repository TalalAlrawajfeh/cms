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
public class SiteManagementController {
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String USER_SESSION_ATTRIBUTE = "user";
	private static final String SITE_MANAGEMENT_JSP = "SiteManagement";
	private static final String SITE_MANAGEMENT_URL = "/site-management";
	private static final String SITES_ATTRIBUTE = "sites";
	private static final String BASE_JSP = "Base";

	@Autowired
	private SiteManagementUseCase siteManagementUseCase;

	@RequestMapping(value = SITE_MANAGEMENT_URL, method = RequestMethod.GET)
	public ModelAndView manage(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE);

		req.setAttribute(CURRENT_USER_ATTRIBUTE, user);
		req.setAttribute(SITES_ATTRIBUTE, siteManagementUseCase.getAllSites());
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, SITE_MANAGEMENT_JSP);

		return new ModelAndView(BASE_JSP);
	}
}
