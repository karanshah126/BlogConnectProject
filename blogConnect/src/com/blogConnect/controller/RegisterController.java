package com.blogConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.User;
import com.blogConnect.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
    
    @RequestMapping("/")
    public ModelAndView initiate() {
       System.out.println("idhar?");
        return new ModelAndView("index"); 
    }
	

 /*  public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/WEB-INF/spring-dispatcher-servlet");
		RegisterController registerController = (RegisterController) applicationContext.getBean("userService");
		registerController.initiate();
	}*/

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		System.out.println("hff");
		userService.insertData(user);
		return new ModelAndView("redirect:/"); // check this
	}
}
