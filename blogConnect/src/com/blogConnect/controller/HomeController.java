package com.blogConnect.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.Blogpost;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;

@Controller

public class HomeController {
	@Autowired
	private BlogpostService blogpostService;
	
	  @RequestMapping("/blogCreation")
	    public ModelAndView redirectToBlog() {
	       System.out.println("TO BLOG CREATION");
	        return new ModelAndView("BlogCreation"); 
	    }
	  
	    @RequestMapping("/home")
	    public ModelAndView initiate() {
	     
	       ModelAndView modelAndView = new ModelAndView("HomePage");
	       modelAndView.addObject("publicBlogpostList",blogpostService.getPublicBlogpostList());
	        return modelAndView; 
	    }
	  
	  
	/*  @RequestMapping("/friendsView")
	    public ModelAndView redirectToFriendsView() {
	       System.out.println("Change to Friends View");
	      ModelAndView mav=new ModelAndView();
	      
	        return new ModelAndView("BlogCreation"); 
	    }*/
}