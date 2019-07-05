package com.niit.backend.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.BlogDAO;
import com.niit.backend.model.Blog;

public class BlogDAOImpl implements BlogDAO{
    @Override
	public boolean addBlog(Blog blog) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			blog.setBlogDate(df.format(date));
			session.save(blog);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addblogdaoimpl error"+e);
			return false;	
		}
		
	}
    @Override
	public boolean deleteBlog(Blog blog) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(blog);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deleteblogdaoimpl error"+e);
			return false;
		}
		
	}
    @Override
	public boolean updateBlog(Blog blog) {
		BlogDAO blogdao = new BlogDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			//blog = blogdao.getBlogById(86);
			blog.setBlogDate(df.format(date));
			//blog.setBlogLikes(1000);
			//blog.setBlogStatus("cookinG is life");
			//blog.setBlogComment("very good");
			//blog.setBlogName("cooking");
			session.update(blog);
			tx.commit();
			session.flush();
			session.close();
			return false;
		}
		catch(Exception e){
			System.out.println("updateblogdaoimpl error"+e);
			return false;	
		}
		
	} 
    @Override
	public List<Blog> getallBlog() {
		List<Blog>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list = (List)session.createQuery("from Blog").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("List<Blog>daoimpl error"+e);
			return list;	
		}
		
	}
    @Override
	public Blog getBlogById(int BlogId) {
		Blog blog=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			blog=(Blog)session.createQuery("from Blog where BLOGID = '"+BlogId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return blog;
		}
		catch(Exception e){
			System.out.println("getblogbyiddaoimpl error"+e);
			return blog;	
		}
		
	}
    @Override
	public List<Blog> getBlogByUserEmail(String UserEmail) {
		List<Blog>list = null;
	    try{
	    	SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
	    	Session session = sessionfactory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	list=(List)session.createQuery("from Blog where USEREMAIL = '"+UserEmail+"'").list();
	    	tx.commit();
	    	session.flush();
	    	session.close();
	    	return list;
	    }
	    catch(Exception e){
	    	System.out.println("getblogbyuseremail error"+e);
	    	return list;	
	    }
	}
    @Override
	public Blog addBlogLike(int BlogId) {
		try{
		BlogDAO blogdao = new BlogDAOImpl();
		Blog blog = blogdao.getBlogById(BlogId);
		int likes = blog.getBlogLikes();
		likes = likes+1;
		blog.setBlogLikes(likes);
		SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(blog);	
		tx.commit();
		session.flush();
		session.close();
		return blog;
		}
		catch(Exception e){
			System.out.println("addbloglikesdaoimpl error"+e);
			return null;	
		}
	}
    @Override
	public Blog addBlogDislike(int BlogId) {
		try{
		BlogDAO blogdao = new BlogDAOImpl();
		Blog blog = blogdao.getBlogById(BlogId);
		int dislikes = blog.getBlogDislikes();
		dislikes = dislikes+1;
		blog.setBlogDislikes(dislikes);
		SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(blog);
		tx.commit();
		session.flush();
		session.close();
		return blog;
		}
		catch(Exception e){
			System.out.println("addblogdislikesdaoimpl error"+e);
			return null;	
		}
	}
    @Override
	public List<Blog> getallOtherUserBlog(String UserEmail) {
		List<Blog>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
	    	Session session = sessionfactory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	list=(List)session.createQuery("from Blog where USEREMAIL != '"+UserEmail+"'").list();
	    	tx.commit();
	    	session.flush();
	    	session.close();
	    	return list;
		}
		catch(Exception e){
			System.out.println("getallOtherUserBlogdaoimpl error"+e);
			return null;	
		}
	}
}
