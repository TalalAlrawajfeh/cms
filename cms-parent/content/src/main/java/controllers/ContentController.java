package controllers;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import usecases.EditSiteUseCase;
import usecases.SiteManagementUseCase;

@Controller
public class ContentController {
	private static final String SUB_SITES_ATTRIBUTE = "subSites";
	private static final String PAGE_URI_PARAMETER = "page_uri";
	private static final String SITE_URI_PARAMETER = "site_uri";
	private static final String SITE_ATTRIBUTE = "site";
	private static final String CONTENT_JSP = "Content";
	private static final String CONTENT_URL = "/content";
	private static final String ROOT_URI = "/root";

	@Autowired
	EditSiteUseCase editSiteUseCase;

	@Autowired
	SiteManagementUseCase siteManagementUseCase;

	@RequestMapping(value = CONTENT_URL, method = RequestMethod.GET)
	public ModelAndView getContent(HttpServletRequest req, HttpServletResponse resp) {
		if (Objects.isNull(req.getParameter(PAGE_URI_PARAMETER))
				&& Objects.isNull(req.getParameter(SITE_URI_PARAMETER))) {

			req.setAttribute(SITE_ATTRIBUTE, editSiteUseCase.getSiteByUri(ROOT_URI));
			req.setAttribute(SUB_SITES_ATTRIBUTE, siteManagementUseCase.getSubSites(ROOT_URI));
		}

		return new ModelAndView(CONTENT_JSP);
	}
}
