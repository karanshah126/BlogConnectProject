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

import com.blogConnect.model.Blogpost;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;

@Controller

public class BlogpostCreationController {
	@Autowired
	private BlogpostService blogpostService;

	@RequestMapping(value = "/createBlogpost", method = RequestMethod.POST)
	public void createBlogpost(@ModelAttribute Blogpost blogpost,  HttpSession session){ 
		
		UserSession userSession=(UserSession) session.getAttribute("session");
		blogpost.setAuthor(userSession.getUsername());
		blogpost.setType("private");
		
		System.out.println(blogpost.getAuthor()+"  "+blogpost.getTitle()+"  "+blogpost.getContent()+"  "+blogpost.getType());
		
		String result = blogpostService.submitBlogpost(blogpost); 
		System.out.println(result);
		
		ArrayList<Blogpost> publicblogpostlist=new ArrayList<Blogpost>();
		publicblogpostlist=(ArrayList<Blogpost>) blogpostService.getPublicBlogpostList();
		
		for (Blogpost item : publicblogpostlist) {   
		    System.out.println(item.getAuthor() + " " + item.getContent());
		}
	/*
			
			ModelAndView modelAndView = new ModelAndView("messageDisplay");
			
			User loginedUser = userService.getUser(user.getEmail());
			usersession.setUsername(loginedUser.getUsername());
			usersession.setIsLogin(true);
			
			// add the session object to the modelandview,
			// so that the jsp template can render different things on html page based on the session
			modelAndView.addObject("session", usersession);
			return modelAndView;*/
		}
	
	@RequestMapping(value = "/hj", method = RequestMethod.POST)
	public void uploadImage(@RequestParam("upload") MultipartFile file ){ 
	
		
		
	}
		
	}
	
