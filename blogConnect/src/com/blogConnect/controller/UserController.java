package com.blogConnect.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.User;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.UserService;

public class UserController {

	private UserService userService;

	@RequestMapping(value = "/messageUser", method = RequestMethod.POST)
	public ModelAndView sendingMessage(){ 
		
		 
	
			ModelAndView modelAndView = new ModelAndView("messageUser");
			return modelAndView;
		}
}
