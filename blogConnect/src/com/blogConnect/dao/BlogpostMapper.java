
	package com.blogConnect.dao;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import org.springframework.jdbc.core.RowMapper;
	import com.blogConnect.model.Blogpost;


	public class BlogpostMapper implements RowMapper<Blogpost> {
	   public Blogpost mapRow(ResultSet rs, int rowNum) throws SQLException {
	     Blogpost blogpost=new Blogpost();
	      blogpost.setPostID(rs.getInt("postID"));
	      blogpost.setAuthor(rs.getString("author"));
	      blogpost.setTitle(rs.getString("title"));
	      blogpost.setContent(rs.getString("content"));
	      blogpost.setType(rs.getString("type"));
	      blogpost.setImage(rs.getString("image"));
	      blogpost.setAuthorimage(rs.getString("authorimage"));
	      return blogpost;
	   }
	}
	
	

