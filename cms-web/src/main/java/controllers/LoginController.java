package controllers;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.User;
import entities.UserEntity;
import persistence.UserRepository;

@Configuration("loginController")
@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("Login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp, @RequestParam String username,
			@RequestParam String password) {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("spring.xml");
		// userRepository = context.getBean(UserRepository.class);

		UserEntity userEntity = userRepository.findByUsername(username);
		if (Objects.isNull(userEntity)) {
			System.out.println("null");
		}

		User user = new User();
		user.setUsername(username);
		user.setHashedPassword(password);

		req.getSession().setAttribute("user", user);
		return new ModelAndView("Login");
	}
}
