package com.github.harmishlakhani.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.harmishlakhani.model.StatusUpdate;
import com.github.harmishlakhani.service.StatusUpdateService;

@Controller
public class PageController {

	@Autowired
	private StatusUpdateService statusUpdateService;
	
	@RequestMapping("/")
	ModelAndView home(ModelAndView modelAndView) {
		modelAndView.setViewName("app.homepage");
		StatusUpdate statusUpdate = statusUpdateService.getLatest();
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		return modelAndView;
	}
	
	@RequestMapping("/about")
	String about() {
		return "app.about";
	}
	
}
