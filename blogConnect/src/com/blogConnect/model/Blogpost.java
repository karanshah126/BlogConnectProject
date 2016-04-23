package com.blogConnect.model;

public class Blogpost {
 
	private long postID;
	private String author;
	private String title;
	private String content;
	private String type;
	private String image;
	private String authorimage;
	
	public long getPostID() {
		return postID;
	}
	public void setPostID(long postID) {
		this.postID = postID;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAuthorimage() {
		return authorimage;
	}
	public void setAuthorimage(String authorimage) {
		this.authorimage = authorimage;
	}
	
}
