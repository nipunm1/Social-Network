package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Blog;

public interface BlogDAO {
public boolean addBlog(Blog blog);
public boolean deleteBlog(Blog blog);
public boolean updateBlog(Blog blog);
public List<Blog>getallBlog();
public Blog getBlogById(int BlogId);
public List<Blog>getBlogByUserEmail(String UserEmail);
public Blog addBlogLike(int BlogId);
public Blog addBlogDislike(int BlogId);
public List<Blog>getallOtherUserBlog(String UserEmail);
}
