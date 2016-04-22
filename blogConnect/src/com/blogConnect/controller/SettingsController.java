package com.blogConnect.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.blogConnect.model.UiCallback;
import com.blogConnect.model.Upload;
import com.blogConnect.model.User;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.UploadService;
import com.blogConnect.service.UserService;

@Controller

public class SettingsController {
	@Autowired
	private UserService userService;
	@Autowired
	private UploadService uploadService;

	@RequestMapping(value = "/updateInfoSettings", method = RequestMethod.POST)
	public ModelAndView createBlogpost(@ModelAttribute User user,  HttpSession session, HttpServletRequest request){ 
		
		 UserSession userSession=(UserSession) session.getAttribute("session");
		

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("upload");
			String imageURL="null";
			
			
			if(!file.isEmpty())
			{
				File convFile =new File(file.getOriginalFilename());
				try {
					convFile.createNewFile();
					FileOutputStream fos= new FileOutputStream(convFile);
					fos.write(file.getBytes());
					fos.close();
				}
				 catch (IOException e) {
					e.printStackTrace();
				}
				
				Upload upload=new Upload();
				upload.image=convFile;
				
				imageURL= uploadService.Execute(upload, new UiCallback());
				System.out.println("URL: "+ imageURL); 
				
				 user.setProfilePicture(imageURL);
				
			}
			
				
		
		String result = userService.updateInfoSettings(user,userSession.getUsername()); 
		System.out.println(result);
	
			ModelAndView modelAndView = new ModelAndView("Settings");
		       modelAndView.addObject("userDetails",userService.getUser(userSession.getUsername()));
			return modelAndView;
		}


	
		
	}

