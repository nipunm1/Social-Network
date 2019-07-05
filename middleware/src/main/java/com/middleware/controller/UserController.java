package com.middleware.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.daoimpl.UserDAOImpl;
import com.niit.backend.model.User;

@RestController
public class UserController {
    @RequestMapping(value="/", method=RequestMethod.GET)  
	public String MiddlewareHome(){
    	System.out.println("***************************");
    	System.out.println("middleware home controller");
    	System.out.println("***************************");
    	
    	
		return "home";
		
	}
    @GetMapping(value="/addUser")
    public JSONObject AddUser(HttpServletRequest req){
    	System.out.println("****************************************");
    	System.out.println("add user middleware controller  " );
    	System.out.println("*****************************************");
    	
    	String useremail = req.getParameter("useremail");
    	String userpassword = req.getParameter("userpassword");
		String username = req.getParameter("username");
		String useraddress = req.getParameter("useraddress");
		String usernumber = req.getParameter("usernumber");
		String str = req.getParameter("userenabled");
		int userenabled = Integer.parseInt(str);
		
		
		User user = new User();
		user.setUserEmail(useremail);
		user.setUserAddress(useraddress);
		user.setUserName(username);
		user.setUserNumber(usernumber);
		user.setUserPassword(userpassword);
    	user.setUserEnabled(userenabled);
    	
    	try{
    		
		UserDAO userdao = new UserDAOImpl();
		
		userdao.addUser(user);
		
		System.out.println("user email =  "+useremail);
		System.out.println("user password =  "+userpassword);
    	System.out.println("user name =  "+username);
    	System.out.println("user address =  "+useraddress);
    	System.out.println("user number =  "+usernumber);
    	System.out.println("user enabled =  "+userenabled);
    	String str1 =  "data inserted in user table";
    	JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(str1);
		return json;
		}
    	catch(Exception e){
    	System.out.println("addusermiddleware error"+e.toString());
    	return null;
    	}
    }
    
    @GetMapping(value="/allUser")
    public List<User> getAllUser(){
    	System.out.println("****************************************");
    	System.out.println("get all user middleware controller  " );
    	System.out.println("*****************************************");
    	try{
    	UserDAO userdao = new UserDAOImpl();
    	List<User>list=userdao.getallUser();
    	Iterator item = list.iterator();
    	while(item.hasNext()){
    		User user = (User)item.next();
    		System.out.println("useremail = "+user.getUserEmail());
    		System.out.println("useraddress = "+user.getUserAddress());
    		System.out.println("userpassword = "+user.getUserPassword());
    		System.out.println("userenabled = "+user.getUserEnabled());
    		System.out.println("username = "+user.getUserName());
    		System.out.println("usernumber = "+user.getUserNumber());
    		System.out.println("*********************************************************");
    	}
    	return list;
    	}
    	catch(Exception e){
    		System.out.println("getallusermiddleware error"+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/userByEmail")
    public User getUserByEmail(@RequestParam("useremail")String UserEmail){
    	System.out.println("******************************************");
    	System.out.println("get user by email middleware controller");
    	System.out.println("******************************************");
    	try{
    		UserDAO userdao = new UserDAOImpl();
    		User user = userdao.getUserByEmail(UserEmail);
    		if(user!=null){
    			System.out.println("useremail = "+user.getUserEmail());
        		System.out.println("useraddress = "+user.getUserAddress());
        		System.out.println("userpassword = "+user.getUserPassword());
        		System.out.println("userenabled = "+user.getUserEnabled());
        		System.out.println("username = "+user.getUserName());
        		System.out.println("usernumber = "+user.getUserNumber());
    		}
    		return user;
    	}
    	catch(Exception e){
    		System.out.println("userbyemailmiddleware error"+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/userByStatus")
    public List<User> getUserByStatus(@RequestParam("userstatus")String UserStatus ,@RequestParam("useremail")String UserEmail){
    	System.out.println("****************************************************");
    	System.out.println("get user by status middleware controller");
    	System.out.println("****************************************************");
    	try{
    		UserDAO userdao = new UserDAOImpl();
    		List<User>list=userdao.getUserByStatus(UserStatus,UserEmail);
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			User user = (User)item.next();
    			System.out.println("useremail = "+user.getUserEmail());
        		System.out.println("useraddress = "+user.getUserAddress());
        		System.out.println("userpassword = "+user.getUserPassword());
        		System.out.println("userenabled = "+user.getUserEnabled());
        		System.out.println("username = "+user.getUserName());
        		System.out.println("usernumber = "+user.getUserNumber());
        		System.out.println("userrole  =  "+user.getUserRole());
        		System.out.println("userstatus  =  "+user.getUserStatus());
        		System.out.println("***************************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("userbystatusmiddleware error"+e.toString());
    		return null;	
    	}
	}
    @GetMapping(value="/logoutUser")
    public JSONObject LogoutUser(@RequestParam("useremail")String UserEmail){
    	System.out.println("*****************************************");
    	System.out.println("logout user middleware controller");
    	System.out.println("*****************************************");
    	try{
    		UserDAO userdao = new UserDAOImpl();
    		User user = userdao.getUserByEmail(UserEmail);
    		if(user==null){
    			System.out.println(user+"User not found");
    		}
    		System.out.println("user email = "+user.getUserEmail());
    		userdao.changeUserStatus(UserEmail, "no");
    		String str =  "user logged out";
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("logoutusermiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/loginUser")
    public JSONObject LoginUser(@RequestParam("useremail")String UserEmail){
    	System.out.println("********************************************");
    	System.out.println("login user middleware controller");
    	System.out.println("********************************************");
    	try{
    		UserDAO userdao = new UserDAOImpl();
    		User user = userdao.getUserByEmail(UserEmail);
    		if(user==null){
    			System.out.println(user+"User not found");
    		}
    		System.out.println("user email = "+user.getUserEmail());
    		userdao.changeUserStatus(UserEmail, "yes");
    		String str =  "user logged in";
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("loginusermiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/deleteUser")
    public String DeleteUser(HttpServletRequest req){
    	System.out.println("************************************");
    	System.out.println("delete user middleware controller");
    	System.out.println("************************************");
    	String useremail = req.getParameter("useremail");
    	try{
    		User user = new User();
    		user.setUserEmail(useremail);
    		UserDAO userdao = new UserDAOImpl();
    		userdao.deleteUser(user);
    		System.out.println("data deleted");
    		return "data deleted from table";
    	}
    	catch(Exception e){
    		System.out.println("deleteusermiddleware error"+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/updateUser")
    public String UpdateUser(HttpServletRequest req){
    	System.out.println("*************************************");
    	System.out.println("update user middleware controller");
    	System.out.println("*************************************");
    	String useremail = req.getParameter("useremail");
    	try{
    		User user = new User();
    		user.setUserEmail(useremail);
    		user.setUserAddress("model town");
    		user.setUserName("kush");
    		user.setUserNumber("9899955862");
    		user.setUserPassword("kush");
    		UserDAO userdao = new UserDAOImpl();
    		userdao.updateUser(user);
    		System.out.println("data updated");
    		return "data updated from table";	
    	}
    	catch(Exception e){
    		System.out.println("updateusermiddleware error"+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/allOtherUser")
    public List<User> getAllOtherUser(@RequestParam("useremail")String UserEmail){
    	System.out.println("*************************************************");
    	System.out.println("all other user middleware controller");
    	System.out.println("*************************************************");
    	try{
    		UserDAO userdao = new UserDAOImpl();
    		List<User>list=userdao.getallOtherUser(UserEmail);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				User user = (User)item.next();
    				System.out.println("useremail = "+user.getUserEmail());
            		System.out.println("useraddress = "+user.getUserAddress());
            		System.out.println("userpassword = "+user.getUserPassword());
            		System.out.println("userenabled = "+user.getUserEnabled());
            		System.out.println("username = "+user.getUserName());
            		System.out.println("usernumber = "+user.getUserNumber());
            		System.out.println("userrole  =  "+user.getUserRole());
            		System.out.println("userstatus  =  "+user.getUserStatus());
            		System.out.println("***************************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getallotherusermiddleware error"+e.toString());
    		return null;	
    	}
	 }
}