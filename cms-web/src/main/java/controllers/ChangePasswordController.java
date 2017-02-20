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
import usecases.EditUserUseCase;
import utils.CopyUtil;
import utils.HashUtil;

@Controller
public class ChangePasswordController {
	private static final String INCORRECT_PASSWORD_MESSAGE = "The old password is incorrect";
	private static final String REDIRECT_USER_MANAGEMENT = "redirect:/user-management";
	private static final String INCLUDED_PAGE_ATTRIBUTE = "includedPage";
	private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
	private static final String USER_SESSION_ATTRIBUTE = "user";
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String SHOW_ERROR_ATTRIBUTE = "showError";
	private static final String CHANGE_PASSWORD_JSP = "ChangePassword";
	private static final String CHANGE_PASSWORD_URL = "/change-password";
	private static final String CANCEL_ACTION = "cancel";
	private static final String BASE_JSP = "base";

	@Autowired
	private EditUserUseCase editUserUseCase;

	@RequestMapping(value = CHANGE_PASSWORD_URL, method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE);

		req.setAttribute(CURRENT_USER_ATTRIBUTE, user);
		req.setAttribute(SHOW_ERROR_ATTRIBUTE, false);
		req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, CHANGE_PASSWORD_JSP);

		return new ModelAndView(BASE_JSP);
	}

	@RequestMapping(value = CHANGE_PASSWORD_URL, method = RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest req, HttpServletResponse resp, @RequestParam String action,
			@RequestParam String oldPassword, @RequestParam String newPassword) {

		if (CANCEL_ACTION.equals(action)) {
			return new ModelAndView(REDIRECT_USER_MANAGEMENT);
		}

		User oldUser = (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE);

		if (!oldUser.getPasswordHashCode().equals(HashUtil.hashString(oldPassword))) {
			req.setAttribute(SHOW_ERROR_ATTRIBUTE, true);
			req.setAttribute(ERROR_MESSAGE_ATTRIBUTE, INCORRECT_PASSWORD_MESSAGE);
			req.setAttribute(INCLUDED_PAGE_ATTRIBUTE, CHANGE_PASSWORD_JSP);

			return new ModelAndView(BASE_JSP);
		}

		User newUser = CopyUtil.createAndCopyFields(User.class, oldUser);
		newUser.setHashedPassword(newPassword);

		editUserUseCase.updateUser(oldUser, newUser);

		req.getSession().setAttribute(USER_SESSION_ATTRIBUTE, newUser);

		return new ModelAndView(REDIRECT_USER_MANAGEMENT);
	}
}
