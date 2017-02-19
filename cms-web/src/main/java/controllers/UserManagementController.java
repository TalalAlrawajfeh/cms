package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.User;
import usecases.UserManagementUseCase;

@Controller
public class UserManagementController {
	private static final String CURRENT_USER_ATTRIBUTE = "currentUser";
	private static final String USER_MANAGEMENT_JSP = "UserManagement";
	private static final String USER_MANAGEMENT_URL = "/user-management";
	private static final String USERS_ATTRIBUTE = "users";

	@Autowired
	private UserManagementUseCase userManagementUseCase;

	@RequestMapping(path = USER_MANAGEMENT_URL, method = RequestMethod.GET)
	public ModelAndView userManagementInit(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		req.setAttribute(CURRENT_USER_ATTRIBUTE, user);
		req.setAttribute(USERS_ATTRIBUTE, userManagementUseCase.getAllUsers());
		return new ModelAndView(USER_MANAGEMENT_JSP);
	}
}
