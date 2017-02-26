package controllers;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.Page;
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
	private static final String ALL_FILTER = "all";
	private static final String BASE_JSP = "Base";

	@Autowired
	private PageManagementUseCase pageManagementUseCase;

	@Autowired
	private SiteManagementUseCase siteManagementUseCase;

	@RequestMapping(value = PAGE_MANAGEMENT_URL, method = RequestMethod.GET)
	public ModelAndView manage(HttpServletRequest req, HttpServletResponse resp, @RequestParam String filter) {
		req.setAttribute(CURRENT_USER_ATTRIBUTE, (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE));
		req.setAttribute(SITES_ATTRIBUTE, siteManagementUseCase.getAllSites());
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, PAGE_MANAGEMENT_JSP);

		if (filter.equals(ALL_FILTER)) {
			setPagesAttribute(req, pageManagementUseCase.getAllPages());
		} else {
			setPagesAttribute(req, StreamSupport.stream(pageManagementUseCase.getAllPages().spliterator(), true)
					.filter(p -> p.getSite().getUri().equals(filter)).collect(Collectors.toList()));
		}

		return new ModelAndView(BASE_JSP);
	}

	public void setPagesAttribute(HttpServletRequest req, Iterable<Page> pages) {
		req.setAttribute(PAGES_ATTRIBUTE, pages);
	}
}
