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
	@Autowired
	private UserManagementUseCase userManagementUseCase;

	@RequestMapping(path = "/user-management", method = RequestMethod.GET)
	public ModelAndView userManagementInit(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		req.setAttribute("currentUser", user);
		req.setAttribute("users", userManagementUseCase.getAllUsers());
		return new ModelAndView("UserManagement");
	}
}
