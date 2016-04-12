package com.blogConnect.model;


public class UserSession {
	private String username;
	private boolean isLogin;
	private String email;
	
	public String getUsername(){
		return this.username;
	}
	
	public boolean isLogin(){
		return this.isLogin;
	}
	
	public String getEmail(){
		return this.email;
	}
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setIsLogin(boolean isLogin){
		this.isLogin = isLogin;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
}
