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
	public ModelAndView createBlogpost(@ModelAttribute Blogpost blogpost,  HttpSession session){ 
		
		UserSession userSession=(UserSession) session.getAttribute("session");
		blogpost.setAuthor(userSession.getUsername());
		blogpost.setType("private");
		
		System.out.println(blogpost.getAuthor()+"  "+blogpost.getTitle()+"  "+blogpost.getContent()+"  "+blogpost.getType());
		
		String result = blogpostService.submitBlogpost(blogpost); 
		System.out.println(result);
		
/*		ArrayList<Blogpost> publicblogpostlist=new ArrayList<Blogpost>();
		publicblogpostlist=(ArrayList<Blogpost>) blogpostService.getPublicBlogpostList();
		
		for (Blogpost item : publicblogpostlist) {   
		    System.out.println(item.getAuthor() + " " + item.getContent());
		}*/
	
			ModelAndView modelAndView = new ModelAndView("BlogCreation");
			modelAndView.addObject("successMessage", result);
			return modelAndView;
		}

	
	@RequestMapping(value = "/hj", method = RequestMethod.POST)
	public void uploadImage(@RequestParam("upload") MultipartFile file ){ 
	
		
		
	}
	
	
	  @RequestMapping("/back")
	public ModelAndView redirectToHome() {
	       System.out.println("TO HOME");
	        return new ModelAndView("HomePage"); 
	    }
		
	}
	
