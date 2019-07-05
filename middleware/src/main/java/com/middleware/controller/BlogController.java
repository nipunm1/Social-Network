package com.middleware.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.BlogDAO;
import com.niit.backend.daoimpl.BlogDAOImpl;
import com.niit.backend.model.Blog;
import com.niit.backend.model.User;

@RestController
public class BlogController {
    @GetMapping(value="/addBlog")
	public JSONObject AddBlog(HttpServletRequest req){
    	System.out.println("***********************************");
    	System.out.println("add blog middleware controller");
    	System.out.println("***********************************");
    	
    	String blogcomment = req.getParameter("blogcomment");
    	String useremail = req.getParameter("useremail");
    	String str = req.getParameter("bloglikes");
    	int bloglikes = Integer.parseInt(str);
    	String str1 = req.getParameter("blogdislikes");
    	int blogdislikes = Integer.parseInt(str1);
    	String str2 = req.getParameter("blogtype");
    	int blogtype = Integer.parseInt(str2);
    	String blogname = req.getParameter("blogname");
    	String blogstatus = req.getParameter("blogstatus");
    	
    	
    	Blog blog = new Blog();
    	blog.setBlogComment(blogcomment);
    	blog.setUserEmail(useremail);
    	blog.setType(blogtype);
    	blog.setBlogLikes(bloglikes);
    	blog.setBlogDislikes(blogdislikes);
    	blog.setBlogName(blogname);
    	blog.setBlogStatus(blogstatus);
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		blogdao.addBlog(blog);
    		System.out.println("useremail = "+useremail);
    		System.out.println("blogtype = "+blogtype);
    		System.out.println("blogcomment = "+blogcomment);
    		System.out.println("bloglikes = "+bloglikes);
    		System.out.println("blogdislikes = "+blogdislikes);
    		System.out.println("blogname = "+blogname);
    		System.out.println("blogstatus = "+blogstatus);
    		String str3 =  "data inserted in blog table";
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str3);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("addblogmiddleware error"+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/allBlog")
    public List<Blog>getAllBlog(HttpServletRequest req){
    	System.out.println("**************************************");
    	System.out.println("all blog middleware controller");
    	System.out.println("**************************************");
    	try{
    	BlogDAO blogdao = new BlogDAOImpl();
    	List<Blog>list=blogdao.getallBlog();
    	Iterator item = list.iterator();
    	while(item.hasNext()){
    		Blog blog = (Blog)item.next();
    		System.out.println("blogid = "+blog.getBlogId());
    		System.out.println("useremail = "+blog.getUserEmail());
    		System.out.println("blogtype = "+blog.getType());
    		System.out.println("blogcomment = "+blog.getBlogComment());
    		System.out.println("blogdate = "+blog.getBlogDate());
    		System.out.println("blogname = "+blog.getBlogName());
    		System.out.println("bloglikes = "+blog.getBlogLikes());
    		System.out.println("blogdislikes = "+blog.getBlogDislikes());
    		System.out.println("blogstatus = "+blog.getBlogStatus());
    		System.out.println("*********************************************");
    	}
    	return list;
    	}
    	catch(Exception e){
    		System.out.println("getallblogmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/blogById")
    public Blog getBlogById(@RequestParam("BlogId")int BlogId){
    	System.out.println("**********************************");
    	System.out.println("blog by id middleware controller");
    	System.out.println("**********************************");
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		Blog blog = blogdao.getBlogById(BlogId);
    		if(blog!=null){
    			System.out.println("blogid = "+blog.getBlogId());
    			System.out.println("useremail = "+blog.getUserEmail());
    			System.out.println("blogtype = "+blog.getType());
        		System.out.println("blogcomment = "+blog.getBlogComment());
        		System.out.println("blogdate = "+blog.getBlogDate());
        		System.out.println("blogname = "+blog.getBlogName());
        		System.out.println("bloglikes = "+blog.getBlogLikes());
        		System.out.println("blogdislikes = "+blog.getBlogDislikes());
        		System.out.println("blogstatus = "+blog.getBlogStatus());
    		}
    		return blog;
    	}
    	catch(Exception e){
    		System.out.println("getblogbyidmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/blogByUserEmail")
    public List<Blog>getBlogByUserEmail(@RequestParam("useremail")String UserEmail){
    	System.out.println("**************************************************");
    	System.out.println("blog by useremail middleware controller");
    	System.out.println("**************************************************");
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		List<Blog>list=blogdao.getBlogByUserEmail(UserEmail);
    		Iterator item = list.iterator();
        	while(item.hasNext()){
        		Blog blog = (Blog)item.next();
        		System.out.println("blogid = "+blog.getBlogId());
        		System.out.println("useremail = "+blog.getUserEmail());
        		System.out.println("blogtype = "+blog.getType());
        		System.out.println("blogcomment = "+blog.getBlogComment());
        		System.out.println("blogdate = "+blog.getBlogDate());
        		System.out.println("blogname = "+blog.getBlogName());
        		System.out.println("bloglikes = "+blog.getBlogLikes());
        		System.out.println("blogdislikes = "+blog.getBlogDislikes());
        		System.out.println("blogstatus = "+blog.getBlogStatus());
        		System.out.println("*********************************************");
        	}
        	return list;
        }
    	catch(Exception e){
    		System.out.println("getblogbyuseremailmiddleware error"+e.toString());
    		return null;	
    	}
	}
    @GetMapping(value="/deleteBlog")
    public JSONObject DeleteBlog(HttpServletRequest req){
    	System.out.println("*****************************************");
    	System.out.println("delete blog middleware controller");
    	System.out.println("*****************************************");
    	String str = req.getParameter("blogid");
    	int blogid = Integer.parseInt(str);
    	try{
    		Blog blog = new Blog();
    		blog.setBlogId(blogid);
    		BlogDAO blogdao = new BlogDAOImpl();
    		blogdao.deleteBlog(blog);
    		System.out.println("data deleted");
    		String str1 =  "data deleted from table";
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str1);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("deleteblogmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/updateBlog")
    public JSONObject UpdateBlog(HttpServletRequest req){
    	System.out.println("**************************************");
    	System.out.println("update blog middleware controller");
    	System.out.println("**************************************");
    	String str = req.getParameter("blogid");
    	int blogid = Integer.parseInt(str);
    	String blogname = req.getParameter("blogname");
    	String blogcomment = req.getParameter("blogcomment");
    	String blogstatus = req.getParameter("blogstatus");
    	String useremail = req.getParameter("useremail");
    	try{
    		Blog blog = new Blog();
    		blog.setBlogId(blogid);
    		blog.setBlogComment(blogcomment);
    		blog.setBlogLikes(0);
    		blog.setBlogDislikes(0);
    		blog.setBlogName(blogname);
    		blog.setBlogStatus(blogstatus);
    		blog.setUserEmail(useremail);
    		BlogDAO blogdao = new BlogDAOImpl();
    		blogdao.updateBlog(blog);
    		System.out.println("data updated");
    		String str1 =  "data updated from table";
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str1);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("updateblogmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/addBlogLike")
    public JSONObject AddBlogLike(@RequestParam("BlogId")int BlogId){
    	System.out.println("************************************");
    	System.out.println("add blog like middleware controller");
    	System.out.println("************************************");
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		Blog blog = blogdao.addBlogLike(BlogId);
    		if(blog!=null){
    			System.out.println("one like added");
    		}
    		String str = "one like added";	
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("addbloglikemiddleware test"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/addBlogDisLike")
    public JSONObject addBlogDisLike(@RequestParam("BlogId")int BlogId){
    	System.out.println("*****************************************");
    	System.out.println("add blog dislike middleware controller");
    	System.out.println("*****************************************");
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		Blog blog = blogdao.addBlogDislike(BlogId);
    		if(blog!=null){
    			System.out.println("one dislike added");
    		}
    		String str =  "one dislike added";	
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("addblogdislikemiddleware test"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/allOtherUserBlog")
    public List<Blog>getallotheruserblog(@RequestParam("useremail")String UserEmail){
    	System.out.println("**********************************************");
    	System.out.println("all other user blog middleware controller");
    	System.out.println("**********************************************");
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		List<Blog>list = blogdao.getallOtherUserBlog(UserEmail);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Blog blog = (Blog)item.next();
    				System.out.println("blogid = "+blog.getBlogId());
            		System.out.println("useremail = "+blog.getUserEmail());
            		System.out.println("blogtype = "+blog.getType());
            		System.out.println("blogcomment = "+blog.getBlogComment());
            		System.out.println("blogdate = "+blog.getBlogDate());
            		System.out.println("blogname = "+blog.getBlogName());
            		System.out.println("bloglikes = "+blog.getBlogLikes());
            		System.out.println("blogdislikes = "+blog.getBlogDislikes());
            		System.out.println("blogstatus = "+blog.getBlogStatus());
            		System.out.println("*********************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getallotherusermiddleware test"+e.toString());
    		return null;	
    	}
    }
}