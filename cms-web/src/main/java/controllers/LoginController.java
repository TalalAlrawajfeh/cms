package controllers;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;
import utils.CopyUtil;
import utils.HashUtil;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) {
		if (Objects.nonNull(req.getSession().getAttribute("user"))) {
			return new ModelAndView("UserManagement");
		}
		return new ModelAndView("Login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp, @RequestParam String username,
			@RequestParam String password) {

		UserEntity userEntity = userRepository.findByUsername(username);
		if (Objects.nonNull(userEntity)) {
			if (password.equalsIgnoreCase(HashUtil.hashString(password))) {
				User user = CopyUtil.createAndCopyFields(User.class, userEntity);
				req.getSession(true).setAttribute("user", user);
				return new ModelAndView("UserManagement");
			}
		}
		return new ModelAndView("Login");
	}
}
