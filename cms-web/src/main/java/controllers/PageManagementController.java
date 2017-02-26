package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.User;
import usecases.PageManagementUseCase;
import usecases.SiteManagementUseCase;

@Controller
public class PageManagementController {
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String USER_SESSION_ATTRIBUTE = "user";
	private static final String PAGE_MANAGEMENT_JSP = "PageManagement";
	private static final String PAGE_MANAGEMENT_URL = "/page-management";
	private static final String PAGES_ATTRIBUTE = "pages";
	private static final String SITES_ATTRIBUTE = "sites";
	private static final String BASE_JSP = "Base";

	@Autowired
	private PageManagementUseCase pageManagementUseCase;

	@Autowired
	private SiteManagementUseCase siteManagementUseCase;

	@RequestMapping(value = PAGE_MANAGEMENT_URL, method = RequestMethod.GET)
	public ModelAndView manage(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute(CURRENT_USER_ATTRIBUTE, (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE));
		req.setAttribute(PAGES_ATTRIBUTE, pageManagementUseCase.getAllPages());
		req.setAttribute(SITES_ATTRIBUTE, siteManagementUseCase.getAllSites());
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, PAGE_MANAGEMENT_JSP);

		return new ModelAndView(BASE_JSP);
	}

}
