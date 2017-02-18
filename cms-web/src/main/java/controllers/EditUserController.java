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

@Controller
public class EditUserController {
	@Autowired
	private EditUserUseCase editUserUserCase;
	private User managedUser;

	@RequestMapping(value = "/edit-user", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest req, HttpServletResponse resp, @RequestParam String username) {
		if (username.equals("admin")) {
			return new ModelAndView("redirect:/user-management");
		}

		// TODO: EDIT USER LOGIC & VIEW

		managedUser = editUserUserCase.getUserFromUsername(username);
		req.setAttribute("managedUser", managedUser);
		return new ModelAndView("EditUser");
	}
}
