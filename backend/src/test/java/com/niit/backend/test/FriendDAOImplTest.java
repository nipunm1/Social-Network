package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.FriendDAO;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.daoimpl.FriendDAOImpl;
import com.niit.backend.daoimpl.UserDAOImpl;
import com.niit.backend.model.Friend;
import com.niit.backend.model.User;

public class FriendDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    @Ignore
	@Test
	public void addfriendtest() {
		System.out.println("addfriendtest begins");
		try{
			Friend friend = new Friend();
			User user = new User();
			user.setUserEmail("niit@niit.com");
			friend.setUserEmail(user);
			friend.setFriendEmailId("nipun@niit.com");
			friend.setFriendType("common");
			friend.setFriendImage("image");
			friend.setFriendUserImage("userimage");
			//friend.setFriendType("confirm");
			FriendDAO frienddao = new FriendDAOImpl();
			boolean b = frienddao.addFriend(friend);
			System.out.println("data added");
			assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addfriendtest error"+e);
		}
	}
    @Ignore
    @Test
    public void getallfriendtest(){
    	System.out.println("getallfriendtest begins");
    	boolean b=false;
    	FriendDAO frienddao = new FriendDAOImpl();
    	try{
    		List<Friend> list = frienddao.getallFriend();
    		if(list!=null){
    			Iterator item=list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend)item.next();
    				System.out.println("friendid = "+friend.getFriendId());
    				System.out.println("friendemailid = "+friend.getFriendEmailId());
    				System.out.println("friendtype = "+friend.getFriendType());
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getallfriendtest error");
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getfriendbyidtest(){
    	System.out.println("getfriendbyidtest begins");
    	boolean b = false;
    	FriendDAO frienddao = new FriendDAOImpl();
    	try{
    		Friend friend = frienddao.getFriendById(65);
    		if(friend!=null){
    			System.out.println("friendid = "+friend.getFriendId());
				System.out.println("friendemailid = "+friend.getFriendEmailId());
				System.out.println("friendtype = "+friend.getFriendType());
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getfriendbyidtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void deletefriendtest(){
    	System.out.println("deletefriendtest begins");
    	try{
    		Friend friend = new Friend();
    		FriendDAO frienddao = new FriendDAOImpl();
    		friend.setFriendId(65);
    		boolean b=frienddao.deleteFriend(friend);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deletefriendtest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updatefriendtest(){
    	System.out.println("updatefriendtest begins");
    	try{
    		Friend friend = new Friend();
    		FriendDAO frienddao = new FriendDAOImpl();
    		boolean b=frienddao.updateFriend(friend);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updatefriendtest error"+e);
    	}
    }
    @Ignore
    @Test
    public void sendfriendrequestbyusertest(){
    	System.out.println("sendfriendrequestbyusertest begins");
    	boolean b=false;
    	FriendDAO frienddao = new FriendDAOImpl();
    	try{
    		List<Friend> list = frienddao.getFriendListByUserEmail("niit@niit.com","nipun@niit.com");
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend)item.next();
    				System.out.println("friendid = "+friend.getFriendId());
    				System.out.println("friendemailid = "+friend.getFriendEmailId());
    				System.out.println("friendtype = "+friend.getFriendType());
    				System.out.println("**************************************************");
    			}
    		}
    		b=true;	
    	}
    	catch(Exception e){
    		System.out.println("sendfriendrequesttest error "+e);
    		b=false;
    	}
    	assertTrue(b);
    }
   @Ignore 
   @Test
   public void friendlistconfirmtest(){
	System.out.println("friendlistconfirmtest begins");
	boolean b=false;
	FriendDAO frienddao = new FriendDAOImpl();
	try{
		List<Friend>list=frienddao.friendListConfirm("confirm");
		if(list!=null){
			Iterator item = list.iterator();
			while(item.hasNext()){
				Friend friend = (Friend)item.next();
				System.out.println("friendid = "+friend.getFriendId());
				System.out.println("useremail = "+friend.getUserEmail());
				System.out.println("friendemailid = "+friend.getFriendEmailId());
				System.out.println("friendtype = "+friend.getFriendType());
				System.out.println("**************************************************");
			}
		}
		b=true;
	}
	catch(Exception e){
		System.out.println("friendlistconfirmtest error"+e);
		b=false;
	}
	assertTrue(b);
   }
   @Ignore
   @Test
   public void confirmfriendlisttest(){
	System.out.println("confirmfriendlisttest begins");
	boolean b=false;
	FriendDAO frienddao = new FriendDAOImpl();
	try{
		List<Friend>list = frienddao.confirmFriendList("neeraj@gmail.com","niit@niit.com","confirm");
		if(list!=null){
			Iterator item = list.iterator();
			while(item.hasNext()){
				Friend friend = (Friend)item.next();
				System.out.println("friendid = "+friend.getFriendId());
				System.out.println("useremail = "+friend.getUserEmail());
				System.out.println("friendemailid = "+friend.getFriendEmailId());
				System.out.println("friendtype = "+friend.getFriendType());
				System.out.println("**************************************************");
			}
		}
		b=true;
	}
	catch(Exception e){
		System.out.println("confirmfriendlisttest error "+e);
		b=false;
	}
	assertTrue(b);
   }
   @Ignore
   @Test
   public void nonconfirmfriendlisttest(){
	   System.out.println("nonconfirmfriendlisttest begins");
		boolean b=false;
		FriendDAO frienddao = new FriendDAOImpl();
		try{
			List<Friend>list = frienddao.nonconfirmFriendList("nipunmiglani.96@gmail.com", "non confirm");
			if(list!=null){
				Iterator item = list.iterator();
				while(item.hasNext()){
					Friend friend = (Friend)item.next();
					System.out.println("friendid = "+friend.getFriendId());
					System.out.println("useremail = "+friend.getUserEmail());
					System.out.println("friendemailid = "+friend.getFriendEmailId());
					System.out.println("friendtype = "+friend.getFriendType());
					System.out.println("**************************************************");
				}
			}
			b=true;
		}
		catch(Exception e){
			System.out.println("nonconfirmfriendlisttest error "+e);
			b=false;
		}
		assertTrue(b);
	   }
   @Ignore
   @Test
   public void convertnonconfirmtoconfirm(){
	   System.out.println("convertnonconfirmtoconfirmtest begins");
	   try{
		FriendDAO frienddao = new FriendDAOImpl();
		frienddao.convertNonconfirmToConfirm(157, "confirm");
		System.out.println("done conversion");
		}
	   catch(Exception e){
		   System.out.println("convertnonconfirmtoconfirmtest error "+e);
	   }
   }
   @Ignore
   @Test
   public void friendrequestsendtousertest(){
	   System.out.println("freindrequestsendtousertest begins");
	   boolean b= false;
	   FriendDAO frienddao = new FriendDAOImpl();
	   try{
	      List<Friend>list=frienddao.FriendRequestSendToUser("niit1@gmail.com","niit@niit.com");
	      if(list!=null){
	    	  Iterator item = list.iterator();
	    	  while(item.hasNext()){
	    		  Friend friend = (Friend)item.next();
	    		  System.out.println("friendid = "+friend.getFriendId());
	    		  System.out.println("friendemailid = "+friend.getFriendEmailId());
	    		  System.out.println("friendtype = "+friend.getFriendType());
	    		  System.out.println("useremail = "+friend.getUserEmail());
	    		  System.out.println("*****************************************************");
	    	  }
	      }
	      b=true;
	   }
	   catch(Exception e){
		   System.out.println("freindrequestsendtousertest error "+e);
	       b=false;
	   }
	   assertTrue(b);
   }
   @Ignore
   @Test
   public void recievenonconfirmfriendrequesttest(){
	   System.out.println("recievenonconfirmfriendrequesttest begins");
	   boolean b=false;
	   FriendDAO frienddao = new FriendDAOImpl();
	   try{
		   List<Friend>list=frienddao.RecieveNonConfirmRequest("nipun@niit.com", "non confirm");
		   if(list!=null){
			   Iterator item = list.iterator();
			   while(item.hasNext()){
				   Friend friend = (Friend)item.next();
				   System.out.println("friendid = "+friend.getFriendId());
				   System.out.println("friendemailid = "+friend.getUserEmail());
				   System.out.println("useremail = "+friend.getFriendEmailId());
				   System.out.println("friendtype = "+friend.getFriendType());
				   System.out.println("*****************************************************");
			   }
			}
		   b=true;
	   }
	   catch(Exception e){
		   System.out.println("recievenonconfirmfriendrequesttest error "+e);
		   b=false;
	   }
	   assertTrue(b);
   }
   @Ignore
   @Test
   public void getfriendbyfriendemailidtest(){
	   System.out.println("getfriendbyfriendemailidtest begins");
	   FriendDAO frienddao = new FriendDAOImpl();
	   Boolean b = false;
	   try{
		   Friend friend = frienddao.getFriendByUserEmail("niit@niit.com");
		   if(friend!=null){
			   System.out.println("friendid = "+friend.getFriendId());
				   System.out.println("friendemailid = "+friend.getFriendEmailId());
				   System.out.println("useremail = "+friend.getUserEmail());
				   System.out.println("friendtype = "+friend.getFriendType());
			  }
		   b=true;
		   }
	   catch(Exception e){
		   System.out.println("getfriendbyfriendemailidtest error"+e);
		   
	   }
	   assertTrue(b);
	   }
   @Ignore
   @Test
   public void deletefriendbyuseremailtest(){
	   System.out.println("deletefriendbyuseremailtest begins");
	try{
		Friend friend = new Friend();
		FriendDAO frienddao = new FriendDAOImpl();
		boolean b=frienddao.deleteFriendByUserEmail("niit@niit.com", "nipunmiglani@gmail.com");
		System.out.println("friend request deleted");
		assertTrue(b);
	}
	catch(Exception e){
		System.out.println("deletefriendbyuseremailtest error"+e);
	}
   }
   @Ignore
   @Test
   public void deletefriendbyfriendemailidtestlist(){
	   System.out.println("deletefriendbyfriendemailidtestlist begins");
	   FriendDAO frienddao = new FriendDAOImpl();
	   boolean b=false;
	   try{
		   Friend friend = frienddao.deleteFriendByFriendEmailId("niit@niit.com", "nipunmiglani.96@gmail.com");
		   if(friend!=null){
			   System.out.println("friendid = "+friend.getFriendId() );
			   System.out.println("friendemailid = "+friend.getFriendEmailId());
			   System.out.println("useremail = "+friend.getUserEmail());
			   System.out.println("friendtype = "+friend.getFriendType());
		   }
		   b=true;
	   }
	   catch(Exception e){
		   System.out.println("deletefriendbyfriendemailidtestlist error"+e);
		   b=false;
	   }
	   assertTrue(b);
   }
  @Ignore
   @Test
   public void getfriendlistbyfriendemailidtest(){
	   System.out.println("getfriendbyfriendemailidtest begins");
	   FriendDAO frienddao = new FriendDAOImpl();
	   boolean b=false;
	   try{
		   List<Friend>list=frienddao.getFriendListByFriendEmailId("sahil@niit.com","niit@niit.com");
		   if(list!=null){
			   Iterator item = list.iterator();
			   while(item.hasNext()){
				Friend friend = (Friend)item.next();
				 System.out.println("friendid = "+friend.getFriendId() );
				   System.out.println("friendemailid = "+friend.getFriendEmailId());
				   System.out.println("useremail = "+friend.getUserEmail());
				   System.out.println("friendtype = "+friend.getFriendType());
			   }
		   }
		   b=true;
	   }
	   catch(Exception e){
		   System.out.println("getfriendbyfriendemailidtest error"+e);
           b=false;	   
	   }
   }
}