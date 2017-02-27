package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditPageController {
	private static final String BASE_JSP = "Base";

	@RequestMapping(value = "/edit-page", method = RequestMethod.GET)
	public ModelAndView editPage(HttpServletRequest req, HttpServletResponse resp, @RequestParam String uri) {
		
		return new ModelAndView(BASE_JSP);
	}
}
