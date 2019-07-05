package com.niit.backend.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.ChatDAO;
import com.niit.backend.model.Chat;

public class ChatDAOImpl implements ChatDAO{

	public boolean addChat(Chat chat) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			chat.setChatDate(df.format(date));
			session.save(chat);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addchatdaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean deleteChat(Chat chat) {
	    try{
	    	SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(chat);
			tx.commit();
			session.flush();
			session.close();
	    	return true;
	    }
	    catch(Exception e){
	    	System.out.println("deletechatdaoimpl error"+e);
	    	return false;	
	    }
		
	}

	public boolean updateChat(Chat chat) {
		ChatDAO chatdao = new ChatDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			//chat = chatdao.getChatById(87);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			chat.setChatDate(df.format(date));
			//chat.setChatMessage("ghf");
			session.update(chat);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updatechatdaoimpl error"+e);
			return false;	
		}
		
	}

	public List<Chat> getallChat() {
		List<Chat>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from Chat").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("List<Chat>daoimpl error"+e);
			return list;	
		}
		
	}

	public Chat getChatById(int ChatId) {
	    Chat chat=null;
	    try{
	    	SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			chat=(Chat)session.createQuery("from Chat where CHATID = '"+ChatId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
	    	return chat;
	    }
	    catch(Exception e){
	    	System.out.println("getchatbyiddaoimpl error"+e);
	    	return chat;	
	    }
		
	}

	@Override
	public List<Chat> getChatFromFriend(String ChatTo, String ChatFrom) {
	    List<Chat>list = null;
		try{
	    	SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
	    	Session session = sessionfactory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	list = (List)session.createQuery("from Chat where CHATTO = '"+ChatTo+"'and CHATFROM = '"+ChatFrom+"'").list();
	    	tx.commit();
	    	session.flush();
	    	session.close();
	    	return list;
	    }
	    catch(Exception e){
	    	System.out.println("getChatFromFrienddaoimpl error "+e);
	    	return null;	
	    }
	}

}