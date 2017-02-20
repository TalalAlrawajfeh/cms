package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.User;
import beans.UserBuilder;
import usecases.AddUserUseCase;

@Controller
public class AddUserController {
	private static final String DUPLICATE_USERNAME_ERROR_MESSAGE = "You entered a username that already exist";
	private static final String REDIRECT_USER_MANAGEMENT = "redirect:/user-management";
	private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String USER_SESSION_ATTRIBUTE = "user";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String SHOW_ERROR_ATTRIBUTE = "showError";
	private static final String COMPLEX_PASSWORD = "P@ssw0rd";
	private static final String ADD_USER_JSP = "AddUser";
	private static final String ADD_USER_URL = "/add-user";
	private static final String BASE_JSP = "base";

	@Autowired
	private AddUserUseCase addUserUseCase;

	@RequestMapping(value = ADD_USER_URL, method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE);

		req.setAttribute(CURRENT_USER_ATTRIBUTE, user);
		req.setAttribute(SHOW_ERROR_ATTRIBUTE, false);
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, ADD_USER_JSP);

		return new ModelAndView(BASE_JSP);
	}

	@RequestMapping(value = ADD_USER_URL, method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, HttpServletResponse resp, @RequestParam String fullName,
			@RequestParam String username) {

		if (addUserUseCase.userExists(username)) {
			req.setAttribute(SHOW_ERROR_ATTRIBUTE, true);
			req.setAttribute(ERROR_MESSAGE_ATTRIBUTE, DUPLICATE_USERNAME_ERROR_MESSAGE);
			req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, ADD_USER_JSP);

			return new ModelAndView(BASE_JSP);
		}

		addUserUseCase.saveUser(new UserBuilder().setEnabled(true).setFullName(fullName).setUsername(username)
				.setHashedPassword(COMPLEX_PASSWORD).build());

		return new ModelAndView(REDIRECT_USER_MANAGEMENT);
	}
}
