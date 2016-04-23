package com.blogConnect.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.Notification;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.NotificationService;
import com.blogConnect.service.SearchService;
import com.blogConnect.service.UserService;


@Controller

public class NotificationController {


	@Autowired	
	private NotificationService notificationService;
	@Autowired
	private BlogpostService blogpostService;
	@Autowired	
	private UserService userService;

    @RequestMapping(value = "/notifications")
	public ModelAndView redirectToNotifications(HttpSession session) {
   
    	UserSession userSession=(UserSession) session.getAttribute("session");
    	ModelAndView modelAndView = new ModelAndView("Notification");
       modelAndView.addObject("notificationList",notificationService.getUserNotificationList(userSession.getUsername()));
        return modelAndView; 
    }
    

    
}
