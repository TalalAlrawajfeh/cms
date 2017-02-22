package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditSiteController {
	private static final String EDIT_SITE_JSP = "EditSite";

	@RequestMapping
	public ModelAndView editSite(HttpServletRequest req, HttpServletResponse resp, @RequestParam String uri) {

		return new ModelAndView(EDIT_SITE_JSP);
	}
}
