package com.blogConnect.model;

public class Notification {

	long notifid;
	String type;
	String content;
	String sendername;
	
	public long getNotifid() {
		return notifid;
	}
	public void setNotifid(long notifid) {
		this.notifid = notifid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	
}
