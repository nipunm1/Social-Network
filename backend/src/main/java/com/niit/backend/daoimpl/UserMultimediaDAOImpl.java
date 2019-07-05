package com.niit.backend.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.UserMultimediaDAO;
import com.niit.backend.model.UserMultimedia;

public class UserMultimediaDAOImpl implements UserMultimediaDAO {
	@Override
	public boolean addUserMultimedia(UserMultimedia usermultimedia) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			usermultimedia.setUserMultimediaTran(df.format(date));
			session.save(usermultimedia);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addusermultimediadaoimpl error"+e);
			return false;	
		}
		
	}
	@Override
	public boolean deleteUserMultimedia(UserMultimedia usermultimedia) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(usermultimedia);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deleteusermultimediadaoimpl error"+e);
			return false;
		}
		
	}
	@Override
	public boolean updateUserMultimedia(UserMultimedia usermultimedia) {
		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			//usermultimedia = usermultimediadao.getUserMultimediaById(55);
		    usermultimedia.setUserMultimediaTran(df.format(date));
			//usermultimedia.setUserMultimediaImage("image1");
			//usermultimedia.setUserMultimediaAudio("audio1");
			//usermultimedia.setUserMultimediaVideo("video1");
			session.update(usermultimedia);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updateusermultimediadaoimpl error"+e);
			return false;
		}
		
	}
	@Override
	public List<UserMultimedia> getallUserMultimedia() {
		List<UserMultimedia>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from UserMultimedia").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("List<UserMultimedia>daoimpl error"+e);
			return list;	
		}
		
	}
	@Override
	public UserMultimedia getUserMultimediaById(int UserMultimediaId) {
		UserMultimedia usermultimedia = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			usermultimedia=(UserMultimedia)session.createQuery("from UserMultimedia where USERMULTIMEDIAID = '"+UserMultimediaId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return usermultimedia;
		}
		catch(Exception e){
			System.out.println("getusermultimediabyiddaoimpl error"+e);
			return usermultimedia;	
		}
		
	}

	@Override
	public List<UserMultimedia> getUserMultimediaByUserEmail(String UserEmail) {
		List<UserMultimedia>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from UserMultimedia where USEREMAIL='"+UserEmail+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("getusermultimediabyuseremaildaoimpl error"+e);
			return list;	
		}
	}
	@Override
	public List<UserMultimedia> getOtherUserMultimediaByUserEmail(String UserEmail) {
		List<UserMultimedia>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from UserMultimedia where USEREMAIL!='"+UserEmail+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("getotherusermultimediabyuseremaildaoimpl error"+e);
			return list;	
		}
	}
	@Override
	public UserMultimedia addUserMultimediaLikes(int UserMultimediaId) {
		try{
			UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
			UserMultimedia usermultimedia = usermultimediadao.getUserMultimediaById(UserMultimediaId);
			int likes = usermultimedia.getUserMultimediaLikes();
			likes = likes+1;
			usermultimedia.setUserMultimediaLikes(likes);
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(usermultimedia);
			tx.commit();
			session.flush();
			session.close();
			return usermultimedia;
		}
		catch(Exception e){
			System.out.println("addusermultimedialikesdaoimpl error"+e);
			return null;
		}
	}
	@Override
	public UserMultimedia addUserMultimediaDislikes(int UserMultimediaId) {
		try{
			UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
			UserMultimedia usermultimedia=usermultimediadao.getUserMultimediaById(UserMultimediaId);
			int dislikes = usermultimedia.getUserMultimeidaDislikes();
			dislikes = dislikes+1;
			usermultimedia.setUserMultimeidaDislikes(dislikes);
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(usermultimedia);
			tx.commit();
			session.flush();
			session.close();
			return usermultimedia;
		}
		catch(Exception e){
			System.out.println("addusermultimediadislikesdaoimpl error"+e);
			return null;	
		}
	}
}