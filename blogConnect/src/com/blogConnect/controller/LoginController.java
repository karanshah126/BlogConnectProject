package com.blogConnect.controller;


import com.blogConnect.model.Blogpost;
import com.blogConnect.model.User;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("session")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private BlogpostService blogpostservice;
	
	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user){ 
		String result = userService.authenticateLogin(user);
	
		
		
		UserSession usersession = new UserSession();
		if (result.equals("success")){
			System.out.println("login sucessfully");
			
			ModelAndView modelAndView = new ModelAndView("HomePage");
			
			User loginedUser = userService.getUser(user.getEmail());
			usersession.setUsername(loginedUser.getUsername());
			usersession.setIsLogin(true);
			
			modelAndView.addObject("session", usersession);
			modelAndView.addObject("blogpostList",blogpostservice.getPublicBlogpostList());
			
			return modelAndView;
		}
		
		else{
			System.out.println(result);
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", result);
			return modelAndView;
		}
	}
	
	//checking for now, remove later
	@RequestMapping(value = "/login")
	 public ModelAndView redirector() {
	       System.out.println("Redirect to messageDisplay");
	        return new ModelAndView("messageDisplay"); 
	    }

	@RequestMapping(value = "/logout")
	public ModelAndView logout() {

		ModelAndView modelAndView = new ModelAndView("redirect:/");
	
		return modelAndView;
	
	}

}