package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.BlogDAO;
import com.niit.backend.daoimpl.BlogDAOImpl;
import com.niit.backend.model.Blog;
import com.niit.backend.model.User;

public class BlogDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    @Ignore
	@Test
	public void addblogtest() {
		System.out.println("addblogtest begins");
		try{
			Blog blog = new Blog();
			blog.setUserEmail("niit@niit.com");
			blog.setType(0);
			blog.setBlogComment("good");
			blog.setBlogLikes(0);
			blog.setBlogDislikes(0);
			blog.setBlogName("TRAVEL");
			blog.setBlogStatus("TRAVEL is life");
			BlogDAO blogdao = new BlogDAOImpl();
			boolean b = blogdao.addBlog(blog);
			System.out.println("data added");
			assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addblogtest error"+e);
		}
	}
    @Ignore
    @Test
    public void getallblogtest(){
    	System.out.println("getallblogtest begins");
    	boolean b=false;
    	BlogDAO blogdao = new BlogDAOImpl();
    	try{
    		List<Blog>list=blogdao.getallBlog();
    		if(list!=null){
    			Iterator item=list.iterator();
    			while(item.hasNext()){
    				Blog blog = (Blog)item.next();
    				
    				System.out.println("blogid = "+blog.getBlogId());
    				System.out.println("blogcomment = "+blog.getBlogComment());
    				System.out.println("blogdate = "+blog.getBlogDate());
    				System.out.println("bloglikes = "+blog.getBlogLikes());
    				System.out.println("blogdislikes = "+blog.getBlogDislikes());
    				System.out.println("blogname = "+blog.getBlogName());
    				System.out.println("blogstatus = "+blog.getBlogStatus());
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getallblogtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getblogbyidtest(){
    	System.out.println("getblogbyidtest begins");
    	boolean b=false;
    	BlogDAO blogdao = new BlogDAOImpl();
    	try{
    		Blog blog = blogdao.getBlogById(85);
    		if(blog!=null){
    			System.out.println("useremail = "+blog.getUserEmail());
    			System.out.println("blogtype = "+blog.getType());
    			System.out.println("blogid = "+blog.getBlogId());
				System.out.println("blogcomment = "+blog.getBlogComment());
				System.out.println("blogdate = "+blog.getBlogDate());
				System.out.println("bloglikes = "+blog.getBlogLikes());
				System.out.println("blogdislikes = "+blog.getBlogDislikes());
				System.out.println("blogname = "+blog.getBlogName());
				System.out.println("blogstatus = "+blog.getBlogStatus());
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getblogbyidtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getblogbyuseremailtest(){
    	System.out.println("getblogbyuseremailtest begins");
    	boolean b=false;
    	BlogDAO blogdao = new BlogDAOImpl();
    	try{
    		List<Blog>list=blogdao.getBlogByUserEmail("niit@niit.com");
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    			Blog blog = (Blog)item.next();	
    			System.out.println("useremail = "+blog.getUserEmail());
    			System.out.println("blogtype = "+blog.getType());
    			System.out.println("blogid = "+blog.getBlogId());
				System.out.println("blogcomment = "+blog.getBlogComment());
				System.out.println("blogdate = "+blog.getBlogDate());
				System.out.println("bloglikes = "+blog.getBlogLikes());
				System.out.println("blogdislikes = "+blog.getBlogDislikes());
				System.out.println("blogname = "+blog.getBlogName());
				System.out.println("blogstatus = "+blog.getBlogStatus());
				System.out.println("******************************************");
    		}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getblogbyuseremailtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void deleteblogtest(){
    	System.out.println("deleteblogtest begins");
    	try{
    		Blog blog = new Blog();
    		BlogDAO blogdao = new BlogDAOImpl();
    		blog.setBlogId(12);
    		boolean b=blogdao.deleteBlog(blog);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deleteblogtest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updateblogtest(){
    	System.out.println("updateblogtest begins");
    	try{
    		Blog blog = new Blog();
    		BlogDAO blogdao = new BlogDAOImpl();
    		boolean b=blogdao.updateBlog(blog);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updateblogtest error"+e);
    	}
    }
    @Ignore
    @Test
    public void addbloglikestest(){
    	System.out.println("addblogliketest begins");
    	boolean b=false;
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		Blog blog=blogdao.addBlogLike(35);
    		if(blog!=null){
    		System.out.println("one like added");
    		}
    		b=true;
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("addblogliketest error"+e);
    		b=false;
    	}
    }
    @Ignore
    @Test
    public void addblogdislikestest(){
    	System.out.println("addblogdisliketest begins");
    	boolean b=false;
    	try{
    		BlogDAO blogdao = new BlogDAOImpl();
    		Blog blog=blogdao.addBlogDislike(35);
    		if(blog!=null){
    		System.out.println("one dislike added");
    		}
    		b=true;
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("addblogdisliketest error"+e);
    		b=false;
    	}
    }
    @Ignore
    @Test
    public void getallotheruserblogtest(){
    	System.out.println("getallotheruserblogtest begins");
    	boolean b=false;
    	BlogDAO blogdao = new BlogDAOImpl();
    	try{
    		List<Blog>list=blogdao.getallOtherUserBlog("niit@niit.com");
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Blog blog = (Blog)item.next();
    				System.out.println("useremail = "+blog.getUserEmail());
        			System.out.println("blogtype = "+blog.getType());
        			System.out.println("blogid = "+blog.getBlogId());
    				System.out.println("blogcomment = "+blog.getBlogComment());
    				System.out.println("blogdate = "+blog.getBlogDate());
    				System.out.println("bloglikes = "+blog.getBlogLikes());
    				System.out.println("blogdislikes = "+blog.getBlogDislikes());
    				System.out.println("blogname = "+blog.getBlogName());
    				System.out.println("blogstatus = "+blog.getBlogStatus());
    				System.out.println("******************************************");
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getallotheruserblogtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
}