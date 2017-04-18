package com.github.harmishlakhani.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.harmishlakhani.model.User;
import com.github.harmishlakhani.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	String login() {
		return "app.login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	ModelAndView register(ModelAndView modelAndView) {
		User user = new User();
		modelAndView.getModel().put("user", user);
		modelAndView.setViewName("app.register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	ModelAndView register(ModelAndView modelAndView, @Valid User user, BindingResult result) {
		modelAndView.setViewName("app.register");
		if(!result.hasErrors()) {
			userService.register(user);
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
}