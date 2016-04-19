package com.blogConnect.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.blogConnect.model.Blogpost;
import com.blogConnect.model.UiCallback;
import com.blogConnect.model.Upload;
import com.blogConnect.model.UserSession;
import com.blogConnect.service.BlogpostService;
import com.blogConnect.service.UploadService;

@Controller

public class BlogpostCreationController {
	@Autowired
	private BlogpostService blogpostService;
	@Autowired
	private UploadService uploadService;
//	@Autowired
//	private Upload upload;

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

	
	@RequestMapping(value = "/post/upload", method = RequestMethod.POST)//, headers="content-type=multipart/form-data")
	//public void uploadImage(@RequestParam("upload") MultipartFile file ){ 
	public void uploadImage(HttpServletRequest request, HttpServletResponse response){	
	System.out.println("hello here");
	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	MultipartFile file = multipartRequest.getFile("upload");
		File convFile =new File(file.getOriginalFilename());
		try {
			convFile.createNewFile();
			FileOutputStream fos= new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Upload upload=new Upload();
		upload.image=convFile;
		
		String url="";
		UiCallback ub = new UiCallback();
		//url = uploadService.Execute(upload, ub);
		 uploadService.Execute(upload, new UiCallback());
		 
		System.out.println("URL: "+ uploadService.responseResult);
	}
	
	public static String getUrl(String url){
		return url;
	}
	
	  @RequestMapping("/back")
	public ModelAndView redirectToHome() {
	       System.out.println("TO HOME");
	        return new ModelAndView("HomePage"); 
	    }
		
	}
	
