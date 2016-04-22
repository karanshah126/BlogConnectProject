package com.blogConnect.controller;


import com.blogConnect.model.Blogpost;
import com.blogConnect.model.User;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.EmailService;
import com.blogConnect.service.LinkCreationService;
import com.blogConnect.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;




@Controller
@SessionAttributes("session")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private BlogpostService blogpostservice;
	@Autowired
	private LinkCreationService linkCreationService;
	@Autowired
	private EmailService emailService;
	
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
		public ModelAndView logout(SessionStatus status){
			  status.setComplete();
		ModelAndView modelAndView = new ModelAndView("index");
	
		return modelAndView;
	
	}
	


	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView forgotPassword(HttpServletRequest request) {
		
		String email=request.getParameter("forgotEmail");
		User checkUser=userService.getUser(email);
		
		String message="Email sent with the link.";
		if(checkUser.getUsername() == null)
			message="The User does not exist.";
		else
		{
			System.out.println("forgot email: "+email);
			String url=linkCreationService.createLink(email);
			try {
				emailService.generateAndSendEmail(email, url);
			
				} catch (MessagingException e) {
					
					e.printStackTrace();
				}
		
		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("errorMessage", message );
		return modelAndView;
	
	}
	
	@RequestMapping(value = "/passwordReset/email/{email}")
	public ModelAndView resetPassword(@PathVariable("email") String email) {
		System.out.println("path email: "+email);
		
		String decodedEmail=linkCreationService.decodeEmail(email);
		System.out.println("decoded email:"+decodedEmail);
		UserSession usersession = new UserSession();
		User loginedUser = userService.getUser(decodedEmail);
		
		usersession.setEmail(decodedEmail);
		usersession.setUsername(loginedUser.getUsername());
		usersession.setIsLogin(true);
		
		ModelAndView modelAndView = new ModelAndView("passwordreset");
		modelAndView.addObject("session", usersession);
		return modelAndView;

		
	}
	
	@RequestMapping(value = "/passwordReset/email/setNewPassword", method = RequestMethod.POST )
	public ModelAndView setNewPassword(HttpServletRequest request, HttpSession session) {
		String newPassword=	request.getParameter("newPassword");
		System.out.println("NEW PASSWORD:"+newPassword);
		UserSession userSession=(UserSession) session.getAttribute("session");
		
		userService.resetPassword(newPassword, userSession.getUsername());
		 ModelAndView modelAndView = new ModelAndView("redirect:/back");
	     
	        return modelAndView; 
	}
}