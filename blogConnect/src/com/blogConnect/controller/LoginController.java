package com.blogConnect.controller;


import com.blogConnect.model.User;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.UserService;

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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user){ // login has two attributes: email and pass, coming from the login page's login form 
		String result = userService.authenticateLogin(user);
		// login successfully
		UserSession usersession = new UserSession();
		if (result.equals("success")){
			System.out.println("login sucessfully");
			
			ModelAndView modelAndView = new ModelAndView("mesu");
			
			User loginedUser = userService.getUser(user);
			usersession.setUsername(loginedUser.getUsername());
			usersession.setIsLogin(true);
			
			// add the session object to the modelandview,
			// so that the jsp template can render different things on html page based on the session
			modelAndView.addObject("session", usersession);
			return modelAndView;
		}
		// password not matched
		else if (result.equals("wrong password")){
			System.out.println("wrong password");
			ModelAndView modelAndView = new ModelAndView("redirect:/");
			return modelAndView;
		}
		// user does not exists
		else{
			System.out.println("user not exists");
			ModelAndView modelAndView = new ModelAndView("redirect:/");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "/login")
	 public ModelAndView redirector() {
	       System.out.println("Redirect to mesu");
	        return new ModelAndView("mesu"); 
	    }}

