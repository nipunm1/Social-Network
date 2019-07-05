package com.middleware.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.FriendDAO;
import com.niit.backend.daoimpl.FriendDAOImpl;
import com.niit.backend.model.Friend;
import com.niit.backend.model.User;

@RestController
public class FriendController {
    @GetMapping(value="/addFriend")
	public JSONObject AddFriend(HttpServletRequest req){
    	System.out.println("********************************************");
    	System.out.println("add friend middleware controller");
    	System.out.println("********************************************");
    	
    	String friendemailid = req.getParameter("friendemailid");
    	String useremail = req.getParameter("useremail");
    	String friendimage = req.getParameter("friendimage");
    	String userfriendimage = req.getParameter("userfriendimage");
    	Friend friend = new Friend();
    	User user = new User();
    	user.setUserEmail(useremail);
    	friend.setFriendImage(friendimage);
        friend.setFriendEmailId(friendemailid);
        friend.setUserEmail(user);
    	friend.setFriendUserImage(userfriendimage);
    	JSONParser parser = new JSONParser();
		try{
    		String s="{\"friend\":true}";  
    		Object obj=JSONValue.parse(s);
    		JSONObject json = (JSONObject) obj;  
    		FriendDAO frienddao = new FriendDAOImpl();
    		boolean b = frienddao.addFriend(friend);
    		System.out.println("friendemailid = "+friendemailid);
    		System.out.println("useremail = "+user);
    		System.out.println("userfriendimage = "+userfriendimage);
    		if(b==true){
            	boolean bool = (boolean)json.get("friend").equals(obj);
    		}
            return json;
    	}
    	catch(Exception e){
    		System.out.println("addfriendmiddleware error"+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/allFriend")
    public List<Friend>getAllFriend(HttpServletRequest req){
    	System.out.println("****************************************");
    	System.out.println("all friend middleware controller");
    	System.out.println("****************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl(); 
    		List<Friend>list=frienddao.getallFriend();
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			Friend friend = (Friend)item.next();
    			System.out.println("friendid = "+friend.getFriendId());
    			System.out.println("friendemailid = "+friend.getFriendEmailId());
    			System.out.println("friendtype = "+friend.getFriendType());
    			System.out.println("**********************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getallfriendmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/friendById")
    public Friend getFriendById(@RequestParam("FriendId")int FriendId){
    	System.out.println("************************************************");
    	System.out.println("friend by id middleware controller");
    	System.out.println("************************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl();
    		Friend friend = frienddao.getFriendById(FriendId);
    		if(friend!=null){
    			System.out.println("friendid = "+friend.getFriendId());
    			System.out.println("friendemailid = "+friend.getFriendEmailId());
    			System.out.println("friendtype = "+friend.getFriendType());
    		}
    		return friend;
    	}
    	catch(Exception e){
    		System.out.println("getfriendbyidmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/deleteFriend")
    public JSONObject DeleteFriend(HttpServletRequest req){
    	System.out.println("******************************************");
    	System.out.println("delete friend middleware controller");
    	System.out.println("******************************************");
    	String str = req.getParameter("friendid");
    	int friendid = Integer.parseInt(str);
    	try{
    	Friend friend = new Friend();
    	friend.setFriendId(friendid);
    	FriendDAO frienddao = new FriendDAOImpl();
    	frienddao.deleteFriend(friend);
    	System.out.println("data deleted");
    	JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse("data deleted");
		return json;
    	}
    	catch(Exception e){
    		System.out.println("deletefriendmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/updateFriend")
    public String UpdateFriend(HttpServletRequest req){
    	System.out.println("***************************************");
    	System.out.println("update friend middleware controller");
    	System.out.println("***************************************");
    	String str = req.getParameter("friendid");
    	int friendid=Integer.parseInt(str);
    	try{
    		Friend friend = new Friend();
    		friend.setFriendId(friendid);
    		friend.setFriendEmailId("deep@gmail.com");
    		friend.setFriendType("mutual");
    		FriendDAO frienddao = new FriendDAOImpl();
    		frienddao.updateFriend(friend);
    		System.out.println("data updated");
    		return "data updated from table";
    	}
    	catch(Exception e){
    		System.out.println("updatefriendmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/getFriendListByUserEmail")
    public List<Friend> getFriendListByUserEmail(@RequestParam("useremail")String UserEmail,@RequestParam("friendemailid")String FriendEmailId){
    	System.out.println("*********************************************************");
    	System.out.println("send friend request middleware controller");
    	System.out.println("*********************************************************");
    	FriendDAO frienddao = new FriendDAOImpl();
		try{
			List<Friend>list = frienddao.getFriendListByUserEmail(UserEmail,FriendEmailId);
			if(list!=null){
				Iterator item = list.iterator();
				while(item.hasNext()){
					Friend friend = (Friend)item.next();
					System.out.println("friendid = "+ friend.getFriendId());
					System.out.println("useremail = "+friend.getUserEmail());
					System.out.println("friendemailid = "+friend.getFriendEmailId());
					System.out.println("friendtype = "+friend.getFriendType());	
				}
			}
			return list;
		}
		catch(Exception e){
			System.out.println("sendfriendrequestmiddleware error "+e.toString());
			return null;
		}
    }
    @GetMapping(value="/getFriendListByFriendEmailId")
    public List<Friend>getFriendListByFriendEmailId(@RequestParam("friendemailid")String FriendEmailId,@RequestParam("useremail")String UserEmail){
    	System.out.println("**********************************************************");
    	System.out.println("get friend list by friendemailid middleware controller");
    	System.out.println("**********************************************************");
    	FriendDAO frienddao = new FriendDAOImpl();
    	try{
    		List<Friend>list=frienddao.getFriendListByFriendEmailId(FriendEmailId,UserEmail);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend)item.next();
    				System.out.println("friendid = "+ friend.getFriendId());
					System.out.println("useremail = "+friend.getUserEmail());
					System.out.println("friendemailid = "+friend.getFriendEmailId());
					System.out.println("friendtype = "+friend.getFriendType());
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getFriendListByFriendEmailIdmiddleware error "+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/friendConfirmList")
    public List<Friend>FriendConfirmList(@RequestParam("friendtype")String FriendType){
    	System.out.println("*****************************************************");
    	System.out.println("friend confirm list middleware controller");
    	System.out.println("*****************************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl();
    		List<Friend>list=frienddao.friendListConfirm(FriendType);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend)item.next();
    				System.out.println("friendid = "+friend.getFriendId());
    				System.out.println("useremail = "+friend.getUserEmail());
    				System.out.println("friendemailid = "+friend.getFriendEmailId());
    				System.out.println("friendtype = "+friend.getFriendType());
    				System.out.println("************************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("friendtypemiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/confirmFriendList")
    public List<Friend>confirmFriendList(@RequestParam("friendemailid")String FriendEmailId,@RequestParam("useremail")String UserEmail,@RequestParam("friendtype")String FriendType){
    	System.out.println("*******************************************");
    	System.out.println("confirm friend list middleware controller");
    	System.out.println("*******************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl();
    		List<Friend>list=frienddao.confirmFriendList(UserEmail, FriendEmailId, FriendType);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend)item.next();
    				System.out.println("friendid = "+friend.getFriendId());
    				System.out.println("useremail = "+friend.getUserEmail());
    				System.out.println("friendemailid = "+friend.getFriendEmailId());
    				System.out.println("friendtype = "+friend.getFriendType());
    				System.out.println("************************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("confirmfriendlistmiddleware error "+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/nonconfirmFriendList")
    public List<Friend>nonconfirmFriendRequest(@RequestParam("useremail")String UserEmail,@RequestParam("friendtype")String FriendType){
    	System.out.println("*******************************************");
    	System.out.println("nonconfirm friend list middleware controller");
    	System.out.println("*******************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl();
    		List<Friend>list=frienddao.nonconfirmFriendList(UserEmail, FriendType);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend)item.next();
    				System.out.println("friendid = "+friend.getFriendId());
    				System.out.println("useremail = "+friend.getUserEmail());
    				System.out.println("friendemailid = "+friend.getFriendEmailId());
    				System.out.println("friendtype = "+friend.getFriendType());
    				System.out.println("************************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("nonconfirmfriendlistmiddleware error "+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/convertNonconfirmToConfirm")
    public JSONObject convertNonconfirmToConfirm(@RequestParam("friendid")int FriendId,@RequestParam("friendtype")String FriendType){
    	System.out.println("********************************************************");
    	System.out.println("convert nonconfirm to confirm middleware controller");
    	System.out.println("********************************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl();
    	    frienddao.convertNonconfirmToConfirm(FriendId,FriendType);
    	    JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse("friend confirm");
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("convertnonconfirmtoconfirmmiddleware error "+e.toString());
    		return null;	
    	}
	}
    @GetMapping(value="/sendfriendrequesttouser")
    public List<Friend>sendFriendRequestToUser(@RequestParam("useremail")String UserEmail,@RequestParam("friendemailid")String FriendEmailId){
    	System.out.println("*********************************************************");
    	System.out.println("send friend request to user middleware controller");
    	System.out.println("*********************************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl();
    		List<Friend>list=frienddao.FriendRequestSendToUser(FriendEmailId, UserEmail);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend)item.next();
    				System.out.println("friendid = "+friend.getFriendId());
    				System.out.println("useremail = "+friend.getUserEmail());
    			    System.out.println("friendemailid = "+friend.getFriendEmailId());
    			    System.out.println("friendtype = "+friend.getFriendType());
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("sendfriendrequesttousermiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/recievenonconfirmfriendrequest")
    public List<Friend>recieveNonConfirmFriendRequest(@RequestParam("useremail")String UserEmail,@RequestParam("friendtype")String FriendType){
    	System.out.println("******************************************************************");
    	System.out.println("recieve non confirm friend request middleware controller");
    	System.out.println("******************************************************************");
    	try{
    		FriendDAO frienddao = new FriendDAOImpl();
    		List<Friend>list = frienddao.RecieveNonConfirmRequest(UserEmail, FriendType);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Friend friend = (Friend) item.next();
    				System.out.println("friendid = "+friend.getFriendId());
    				System.out.println("useremail = "+friend.getFriendEmailId());
    				System.out.println("friendemailid = "+friend.getUserEmail());
    				System.out.println("friendtype = "+friend.getFriendType());
    				System.out.println("******************************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("recievenonconfirmfriendrequestmiddleware error "+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/deleteFriendByEmailAndFriend")
    public JSONObject deleteFriendByUserEmailAndFriendEmailId(@RequestParam("friendemailid")String FriendEmailId,@RequestParam("useremail")String UserEmail){
		System.out.println("***********************************************************************");
		System.out.println("delete friend by useremail and friendemailid middleware controller");
		System.out.println("***********************************************************************");
		try{
			FriendDAO frienddao = new FriendDAOImpl();
		    frienddao.deleteFriendByUserEmail(FriendEmailId, UserEmail);
			JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse("friend confirm");
    		return json;
		}
		catch(Exception e){
			System.out.println("deletefriendbyemailandfriendmiddleware error "+e.toString());
			return null;
		}
    	
    }
}