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
import usecases.AddUserUseCase;

@Controller
public class AddUserController {
	@Autowired
	private AddUserUseCase addUserUserCase;

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("user");
		req.setAttribute("currentUser", user);
		return new ModelAndView("AddUser");
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, HttpServletResponse resp, @RequestParam String fullName,
			@RequestParam String username) {
		User user = new User();
		user.setEnabled(true);
		user.setFullName(fullName);
		user.setUsername(username);
		user.setHashedPassword("P@ssw0rd");
		addUserUserCase.saveUser(user);
		return new ModelAndView("redirect:user-management");
	}
}
