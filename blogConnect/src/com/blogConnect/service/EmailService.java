package com.blogConnect.service;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 

public class EmailService {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
/* 
	public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail();
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}*/
 
	public void generateAndSendEmail(String userEmail, String link) throws AddressException, MessagingException {
 
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
	
		
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		
		
		
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
		
		
		generateMailMessage.setSubject("Greetings from BlogConnect");
		
		String emailBody = "Hey! Click the link below to reset your password:" +"<br><br>"+ link + "<br><br> Regards, <br>BlogConnect team";
		generateMailMessage.setContent(emailBody, "text/html");
		
		Transport transport = getMailSession.getTransport("smtp");
 
		transport.connect("smtp.gmail.com", "blogconnectapp", "karanseth");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}