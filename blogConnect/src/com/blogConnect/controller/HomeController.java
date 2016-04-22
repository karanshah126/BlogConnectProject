package com.blogConnect.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.Blogpost;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.SearchService;
import com.blogConnect.service.UserService;

@Controller

public class HomeController {
	@Autowired
	private BlogpostService blogpostService;
	@Autowired	
	private UserService userService;

	
	  @RequestMapping("/blogCreation")
	    public ModelAndView redirectToBlog() {
	       System.out.println("TO BLOG CREATION");
	        return new ModelAndView("BlogCreation"); 
	    }
	  
	    @RequestMapping("/homepage")
	    public ModelAndView refreshToHome() {
	     
	       ModelAndView modelAndView = new ModelAndView("HomePage");
	       modelAndView.addObject("blogpostList",blogpostService.getPublicBlogpostList());
	        return modelAndView; 
	    }
	    
	    @RequestMapping("/friendsView")
	    public ModelAndView refreshToFriendView(HttpSession session) {
	     
	    	UserSession userSession=(UserSession) session.getAttribute("session");
	       ModelAndView modelAndView = new ModelAndView("HomePage");
	       modelAndView.addObject("blogpostList",blogpostService.getPrivateBlogpostList(userSession.getUsername()));
	        return modelAndView; 
	    }
	    
	    @RequestMapping("/changeSettings")
	    public ModelAndView redirectToChangeSettings(HttpSession session) {
	     
	    	UserSession userSession=(UserSession) session.getAttribute("session");
	    	ModelAndView modelAndView = new ModelAndView("Settings");
	       modelAndView.addObject("userDetails",userService.getUser(userSession.getUsername()));
	        return modelAndView; 
	    }
	    
		  @RequestMapping("/back")
			public ModelAndView redirectToHome() {
			       System.out.println("TO HOME");
					ModelAndView modelAndView = new ModelAndView("HomePage");
					  modelAndView.addObject("blogpostList",blogpostService.getPublicBlogpostList());
					  return modelAndView;
			    }
 }
	  
