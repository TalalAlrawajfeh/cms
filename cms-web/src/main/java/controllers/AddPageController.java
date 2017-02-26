package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.PageBuilder;
import beans.User;
import usecases.AddPageUseCase;
import usecases.EditSiteUseCase;
import usecases.SiteManagementUseCase;

@Controller
public class AddPageController {
	private static final String REDIRECT_PAGE_MANAGEMENT = "redirect:/page-management?filter=all";
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String USER_SESSION_ATTRIBUTE = "user";
	private static final String SITES_ATTRIBUTE = "sites";
	private static final String ADD_PAGE_JSP = "AddPage";
	private static final String ADD_PAGE_URL = "/add-page";
	private static final String BASE_JSP = "Base";

	@Autowired
	private SiteManagementUseCase siteManagementUseCase;

	@Autowired
	private EditSiteUseCase editSiteUseCase;

	@Autowired
	private AddPageUseCase addPageUseCase;

	@RequestMapping(value = ADD_PAGE_URL, method = RequestMethod.GET)
	public ModelAndView addPage(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute(CURRENT_USER_ATTRIBUTE, (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE));
		req.setAttribute(SITES_ATTRIBUTE, siteManagementUseCase.getAllSites());
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, ADD_PAGE_JSP);

		return new ModelAndView(BASE_JSP);
	}

	@RequestMapping
	public ModelAndView addPage(HttpServletRequest req, HttpServletResponse resp, @RequestParam String title,
			@RequestParam String uri, @RequestParam String site, @RequestParam String seo,
			@RequestParam String content) {

		addPageUseCase.savePage(new PageBuilder().setTitle(title).setUri(site + uri).setIsHtml(true).setSeo(seo)
				.setContent(content).setSite(editSiteUseCase.getSiteByUri(site)).build());

		return new ModelAndView(REDIRECT_PAGE_MANAGEMENT);
	}
}
