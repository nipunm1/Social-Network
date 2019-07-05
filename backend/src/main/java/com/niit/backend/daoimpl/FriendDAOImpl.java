package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.FriendDAO;
import com.niit.backend.model.Friend;
import com.niit.backend.model.User;

public class FriendDAOImpl implements FriendDAO{

	public boolean addFriend(Friend friend) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			friend.setFriends(0);
			friend.setFriendType("non confirm");
			session.save(friend);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addfrienddaoimpl error"+e);
			return false;	
		}
		
	}
	@Override
	public boolean deleteFriend(Friend friend) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(friend);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deletefrienddaoimpl error"+e);
			return false;
		}
		
	}
	@Override
	public boolean updateFriend(Friend friend) {
		FriendDAO frienddao = new FriendDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			//friend = frienddao.getFriendById(63);
			//friend.setFriendEmailId("kush@gmail.com");
			//friend.setFriendType("mutual");
			session.update(friend);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updatefrienddaoimpl error"+e);
			return false;
		}
		
	}
	@Override
	public List<Friend> getallFriend() {
		List<Friend>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from Friend").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("List<Friend>daoimpl error"+e);
			return list;	
		}
		
	}
    @Override
	public Friend getFriendById(int FriendId) {
		Friend friend = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			friend = (Friend)session.createQuery("from Friend where FRIENDID = '"+FriendId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return friend;
		}
		catch(Exception e){
			System.out.println("getfriendbyiddaoimpl error"+e);
			return friend;	
		}
	}
	@Override
	public List<Friend> getFriendListByUserEmail(String UserEmail,String FriendEmailId) {
		List<Friend>list = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list = (List)session.createQuery("from Friend where USEREMAIL = '"+UserEmail+"' and FRIENDEMAILID = '"+FriendEmailId+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("sendfriendrequestbyuserdaoimpl error "+e);
			return null;
		}
	}
	
	@Override
	public List<Friend> confirmFriendList(String UserEmail,String FriendEmailId,String FriendType) {
		List<Friend>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
		    list = (List)session.createQuery("from Friend where FRIENDTYPE = '"+FriendType+"'and USEREMAIL = '"+UserEmail+"'and FRIENDEMAILID = '"+FriendEmailId+"'").list();
		    tx.commit();
		    session.flush();
		    session.close();
		    return list;
		}
		catch(Exception e){
			System.out.println("confirmfriend<list>daoimpl error "+e);
			return null;	
		}
	}
	@Override
	public List<Friend> nonconfirmFriendList(String UserEmail, String FriendType) {
		List<Friend>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
		    list = (List)session.createQuery("from Friend where USEREMAIL = '"+UserEmail+"'and FRIENDTYPE = '"+FriendType+"'").list();
		    tx.commit();
		    session.flush();
		    session.close();
		    return list;
		}
		catch(Exception e){
			System.out.println("confirmfriend<list>daoimpl error "+e);
			return null;	
		}
	}
	@Override
	public boolean convertNonconfirmToConfirm(int FriendId,String FriendType) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			FriendDAO frienddao = new FriendDAOImpl();
			Friend friend = frienddao.getFriendById(FriendId);
			friend.setFriendType(FriendType);
			session.update(friend);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("convertnoncifirmtoconfirmdaoimpl error "+e);
			return false;	
		}
	}
	@Override
	public List<Friend> FriendRequestSendToUser(String FriendEmailId,String UserEmail) {
		List<Friend> list = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from Friend where FRIENDEMAILID = '"+FriendEmailId+"'and USEREMAIL = '"+UserEmail+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("friendrequestsendtouserdaoimpl error"+e);
			return null;	
		}
	}
	@Override
	public List<Friend> RecieveNonConfirmRequest(String FriendEmailId, String FriendType) {
		List<Friend>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from Friend where FRIENDEMAILID = '"+FriendEmailId+"'and FRIENDTYPE = '"+FriendType+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("recievenonconfirmrequestdaoimpl error "+e);
			return null;	
		}
	}
	@Override
	public Friend getFriendByUserEmail(String UserEmail) {
		Friend friend=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			friend=(Friend)session.createQuery("from Friend where USEREMAIL = '"+UserEmail+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return friend;
		}
		catch(Exception e){
			System.out.println("getFriendbyfriendemailiddaoimpl error"+e);
			return null;
		}
	}
	@Override
	public boolean deleteFriendByUserEmail(String UserEmail,String FriendEmailId) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			FriendDAO frienddao = new FriendDAOImpl();
			Friend friend = frienddao.deleteFriendByFriendEmailId(UserEmail, FriendEmailId);
			session.delete(friend);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deleteFriendByUserEmaildaoimpl error"+e);
			return false;	
		}
	}
	@Override
	public Friend deleteFriendByFriendEmailId(String FriendEmailId, String UserEmail) {
		Friend friend = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			friend = (Friend)session.createQuery("from Friend where FRIENDEMAILID = '"+FriendEmailId+"'and USEREMAIL = '"+UserEmail+"'").uniqueResult();
            tx.commit();
            session.flush();
            session.close();
			return friend;
		}
		catch(Exception e){
			System.out.println("deletefriendbyfriendemailiddaoimpl error"+e);
			return null;	
		}
	}
	@Override
	public List<Friend> friendListConfirm(String FriendType) {
		List<Friend>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list = (List)session.createQuery("from Friend where FRIENDTYPE = '"+FriendType+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("friendListConfirmdaoimpl error "+e);
			return null;	
		}
	}
	@Override
	public List<Friend> getFriendListByFriendEmailId(String FriendEmailId,String UserEmail) {
		List<Friend>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list = (List)session.createQuery("from Friend where FRIENDEMAILID = '"+FriendEmailId+"'and USEREMAIL = '"+UserEmail+"'").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("getFriendListByFriendEmailIddaoimpl error"+e);
			return null;	
		}
	}
}