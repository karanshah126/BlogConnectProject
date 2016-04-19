package com.blogConnect.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.User;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.UserService;

@Controller

public class SettingsController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/updateSettings", method = RequestMethod.POST)
	public ModelAndView createBlogpost(@ModelAttribute User user,  HttpSession session){ 
		
		 UserSession userSession=(UserSession) session.getAttribute("session");
		
		
		String result = userService.updateSettings(user,userSession.getUsername()); 
		System.out.println(result);
	
			ModelAndView modelAndView = new ModelAndView("UpdateSettings");
			return modelAndView;
		}


	
		
	}

