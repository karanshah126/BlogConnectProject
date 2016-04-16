package com.blogConnect.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.blogConnect.model.Blogpost;

public class BlogpostDAO {

	private JdbcTemplate jdbcTemplate;
	
	DataSource dataSource;   
	
	public void setDataSource(DataSource dataSource) {
	     this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	    

	public void insertBlogpost(Blogpost blogpost) {
	
       String sql = "INSERT INTO blogpost (author, title, content, type)"
	                    + " VALUES (?, ?, ?, ?)";
       
				jdbcTemplate.update(sql, blogpost.getAuthor(), blogpost.getTitle(), 
						blogpost.getContent(), blogpost.getType() );		
		
	}

 
	public List<Blogpost> getPublicBlogpostList() {
		
	/*	Blogpost nullPost=new Blogpost();  
		nullPost.setAuthor(null);
		nullPost.setContent(null);
		nullPost.setPostID(0);
		nullPost.setTitle(null);
		nullPost.setType(null);
		*/
		
		
		  List<Blogpost> blogpostList = new ArrayList<Blogpost>();  
		  String sql = "select * from blogpost where type='public' ORDER BY postID DESC";  
		  blogpostList = jdbcTemplate.query(sql, new BlogpostMapper());  
		
			  return blogpostList;
	}
	
	
	
	public List<Blogpost> getPrivateBlogpostList(String username) {
		

		  List<Blogpost> blogpostList = new ArrayList<Blogpost>();  
		  String sql = "select * from blogpost where type= 'private' AND author IN (select friendname from friends where username='" 
				  		+username+
		            "') ORDER BY postID DESC";;  
		  blogpostList = jdbcTemplate.query(sql, new BlogpostMapper());  
		
			  return blogpostList;
		

	}

	public List<Blogpost> getUserBlogpostList(String username,String userInSession) {
		
	/*	Blogpost nullPost=new Blogpost();  
		nullPost.setAuthor(null);
		nullPost.setContent(null);
		nullPost.setPostID(0);
		nullPost.setTitle(null);
		nullPost.setType(null);
		
		IF 
		
		*/
		
		
		  List<Blogpost> blogpostList = new ArrayList<Blogpost>();  
		  
		  String sql = "SELECT * FROM blogpost WHERE type='public' AND author='"+username
				  +"' union SELECT blogpost.* FROM blogpost inner join friends f1 ON blogpost.author=f1.username"+
				  "WHERE blogpost.type='private'  AND blogpost.author='"+username+
				  "' AND  EXISTS (select * from friends f2 where f2.username='"
				  +userInSession+"' and f2.friendname='"+username+"') Order by postID DESC";  
		  
		  
		  blogpostList = jdbcTemplate.query(sql, new BlogpostMapper());  
		
			  return blogpostList;
	}


}
