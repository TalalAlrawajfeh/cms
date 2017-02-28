package controllers;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.Page;
import beans.SiteSettings;
import usecases.EditSiteUseCase;
import usecases.PageManagementUseCase;
import usecases.SiteManagementUseCase;
import usecases.SiteSettingsUseCase;

@Controller
public class ContentController {
	private static final String SELECTED_PAGE_ATTRIBUTE = "selectedPage";
	private static final String WEBSITE_NAME_ATTRIBUTE = "websiteName";
	private static final String SUB_SITES_ATTRIBUTE = "subSites";
	private static final String PAGE_URI_PARAMETER = "page_uri";
	private static final String SITE_URI_PARAMETER = "site_uri";
	private static final String PAGES_ATTRIBUTE = "pages";
	private static final String IMAGE_ATTRIBUTE = "image";
	private static final String SITE_ATTRIBUTE = "site";
	private static final String CONTENT_JSP = "Content";
	private static final String DELIVERY_URL = "/delivery";
	private static final String ROOT_URI = "/root";

	@Autowired
	EditSiteUseCase editSiteUseCase;

	@Autowired
	SiteManagementUseCase siteManagementUseCase;

	@Autowired
	PageManagementUseCase pageManagementUseCase;

	@Autowired
	SiteSettingsUseCase siteSettingsUseCase;

	@RequestMapping(value = DELIVERY_URL, method = RequestMethod.GET)
	public ModelAndView getContent(HttpServletRequest req, HttpServletResponse resp) {
		String pageUriParameter = req.getParameter(PAGE_URI_PARAMETER);
		String siteUriParameter = req.getParameter(SITE_URI_PARAMETER);

		if (Objects.isNull(pageUriParameter) && Objects.isNull(siteUriParameter)) {
			setProperAttributes(req, ROOT_URI, null);
		}

		if (Objects.nonNull(siteUriParameter)) {
			setProperAttributes(req, siteUriParameter, null);
		} else if (Objects.nonNull(pageUriParameter)) {
			Page selectedPage = pageManagementUseCase.getPageByUri(pageUriParameter);
			String siteUri = selectedPage.getSite().getUri();
			setProperAttributes(req, siteUri, selectedPage);
		}

		return new ModelAndView(CONTENT_JSP);
	}

	private void setProperAttributes(HttpServletRequest req, String siteUri, Page selectedPage) {
		req.setAttribute(SITE_ATTRIBUTE, editSiteUseCase.getSiteByUri(siteUri));
		req.setAttribute(SUB_SITES_ATTRIBUTE, siteManagementUseCase.getSubSites(siteUri));
		req.setAttribute(PAGES_ATTRIBUTE, pageManagementUseCase.getPagesOfSite(siteUri));

		SiteSettings siteSettings = siteSettingsUseCase.getSiteSettings();
		req.setAttribute(IMAGE_ATTRIBUTE, DatatypeConverter.printBase64Binary(siteSettings.getLogo()));
		req.setAttribute(WEBSITE_NAME_ATTRIBUTE, siteSettings.getName());

		if (Objects.nonNull(selectedPage)) {
			req.setAttribute(SELECTED_PAGE_ATTRIBUTE, selectedPage);
		}
	}
}