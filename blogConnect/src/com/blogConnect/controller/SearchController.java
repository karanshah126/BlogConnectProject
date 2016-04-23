package com.blogConnect.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.SearchService;
import com.blogConnect.service.UserService;
@Controller
public class SearchController {
	
	@Autowired	
	private SearchService searchService;
	@Autowired
	private BlogpostService blogpostService;
	@Autowired	
	private UserService userService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView forgetPassword(HttpServletRequest request ){
		String searchString=request.getParameter("searchString");
		
    	ModelAndView modelAndView = new ModelAndView("SearchPage");
       modelAndView.addObject("searchResults",searchService.getSearchResults(searchString));
        return modelAndView; 
    }
    
    @RequestMapping(value = "/{username}")
	public ModelAndView goToUserPage(@PathVariable("username") String username,HttpSession session) {
   
  
    	UserSession userSession=(UserSession) session.getAttribute("session");
    	ModelAndView modelAndView = new ModelAndView("UserPage");
    	  modelAndView.addObject("userDetails",userService.getUser(username));
    	  modelAndView.addObject("blogpostList",blogpostService.getUserBlogpostList(username, userSession.getUsername()));
    	  modelAndView.addObject("connectStatus", userService.friendStatus(userSession.getUsername(), username));
        return modelAndView; 
    }
    
    
}
