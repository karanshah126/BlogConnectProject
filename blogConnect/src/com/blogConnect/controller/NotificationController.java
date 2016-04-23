package com.blogConnect.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.blogConnect.model.UserSession;
import com.blogConnect.service.NotificationService;


@Controller

public class NotificationController {


	@Autowired	
	private NotificationService notificationService;


    @RequestMapping(value = "/notifications")
	public ModelAndView redirectToNotifications(HttpSession session) {
   
    	UserSession userSession=(UserSession) session.getAttribute("session");
    	ModelAndView modelAndView = new ModelAndView("Notification");
       modelAndView.addObject("notificationList",notificationService.getUserNotificationList(userSession.getUsername()));
        return modelAndView; 
    }
    

    
}
