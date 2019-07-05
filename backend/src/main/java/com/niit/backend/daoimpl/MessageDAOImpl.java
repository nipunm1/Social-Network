package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.MessageDAO;
import com.niit.backend.model.Message;

public class MessageDAOImpl implements MessageDAO{

	public boolean addMessage(Message message) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(message);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addmessagedaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean deleteMessage(Message message) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(message);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deletemessagedaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean updateMessage(Message message) {
		MessageDAO messagedao = new MessageDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			//message = messagedao.getMessageById(57);
			//message.setMessageFrom("kush");
			//message.setMessageText("abc");
			session.update(message);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updatemessagedaoimpl error"+e);
			return false;	
		}
		
	}

	public List<Message> getallMessage() {
	    List<Message>list=null;
	    try{
	    	SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from Message").list();
			tx.commit();
			session.flush();
			session.close();
	    	return list;
	    }
	    catch(Exception e){
	    	System.out.println("List<Message>daoimpl error"+e);
	    	return list;	
	    }
		
	}

	public Message getMessageById(int MessageId) {
		Message message = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			message=(Message)session.createQuery("from Message where MESSAGEID = '"+MessageId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return message;	
		}
		catch(Exception e){
			System.out.println("getmessagebyiddaoimpl error"+e);
			return message;
		}
		
	}

}
