package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;

public class UserDAOImpl implements UserDAO{
	@Override
	public boolean addUser(User user) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			user.setUserRole("Normal User");
			user.setUserStatus("no");
			session.save(user);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addUserdaoimpl error"+e);
			return false;	
		}
		
	}
	@Override
	public boolean deleteUser(User user) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deleteuserdaoimpl error"+e);
			return false;	
		}
		
	}
	@Override
	public boolean updateUser(User user) {
		UserDAO userdao = new UserDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			//user.setUserRole("Normal User");
			user.setUserStatus("yes");
			user = userdao.getUserByEmail("niit@gmail.com");
			//user.setUserAddress("Kohat Enclave");
			//user.setUserName("sahil");
			//user.setUserNumber("888888888888");
			//user.setUserPassword("4567");
			session.update(user);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updateuserdaoimpl error"+e);
			return false;	
		}
		
	}
	@Override
	public List<User> getallUser() {
		List<User>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list = (List)session.createQuery("from User").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
				System.out.println("List<User>daoimpl error"+e);
			return list;	
		}
		
	}
	@Override
	public User getUserByEmail(String UserEmail) {
		User user = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			user=(User)session.createQuery("from User where USEREMAIL = '"+UserEmail+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return user;
		}
		catch(Exception e){
			System.out.println("getuserbyemaildaoimpl error"+e);
			return user;	
		}
		
	}
	@Override
	public List<User> getUserByStatus(String UserStatus , String UserEmail) {
		List<User>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list = (List)session.createQuery("from User where USERSTATUS = '"+UserStatus+"' and USEREMAIL = '"+UserEmail+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("getuserbystatusdaoimpl error"+e);
			return list;
		}
	}
	@Override
	public boolean changeUserStatus(String UserEmail, String UserStatus) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			UserDAO userdao = new UserDAOImpl();
			User user = userdao.getUserByEmail(UserEmail);
			user.setUserStatus(UserStatus);
			session.update(user);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("changeuserstatusdaoimpl error"+e);
			return false;	
		}
	}

	@Override
	public List<User> getallOtherUser(String UserEmail) {
		List<User>list=null;
		try{
		    SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
		    Session session = sessionfactory.openSession();
		    Transaction tx = session.beginTransaction();
		    list = (List)session.createQuery("from User where USEREMAIL != '"+UserEmail+"'").list();
		    tx.commit();
		    session.flush();
		    session.close();
		    return list;
		}
		catch(Exception e){
			System.out.println("getallotheruserdaoimpl error"+e);
			return null;
		}
	}
}