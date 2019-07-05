package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.daoimpl.UserDAOImpl;
import com.niit.backend.model.User;

public class UserDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    
	@Test
	public void addusertest() {
		System.out.println("addusertest begins");
		try{
			User user = new User();
			user.setUserAddress("PitamPura");
	        user.setUserEmail("niit@niit.com");
	        user.setUserEnabled(0);
	        user.setUserName("nipun miglani");
	        user.setUserNumber("9999664813");
	        user.setUserPassword("1234");
	        //user.setUserRole("Admin");
	        //user.setUserStatus("yes");
	        UserDAO userdao = new UserDAOImpl();
	        boolean b = userdao.addUser(user);
	        System.out.println("data added");
	        assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addusertest error"+e);
		}
		
	}
    @Ignore
    @Test
    public void getallusertest(){
    	System.out.println("getallusertest begins");
    	boolean b=false;
    	UserDAO userdao = new UserDAOImpl();
    	try{
    		List<User>list=userdao.getallUser();
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				User user = (User)item.next();
    				System.out.println("useremail = "+user.getUserEmail());
    				System.out.println("userpassword = "+user.getUserPassword());
    				System.out.println("useraddress = "+user.getUserAddress());
    				System.out.println("usernumber = "+user.getUserNumber());
    				System.out.println("username = "+user.getUserName());
    				System.out.println("userenabled = "+user.getUserEnabled());
    				System.out.println("userstatus = "+user.getUserStatus());
    				System.out.println("userrole = "+user.getUserRole());
    				System.out.println("**************************************************");
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getallusertest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getuserbyemailtest(){
    	System.out.println("getuserbyemailtest begins");
    	boolean b=false;
    	UserDAO userdao = new UserDAOImpl();
    	try{
    		User user = userdao.getUserByEmail("niit@niit.com");
    		if(user!=null){
    			System.out.println("useremail = "+user.getUserEmail());
				System.out.println("userpassword = "+user.getUserPassword());
				System.out.println("useraddress = "+user.getUserAddress());
				System.out.println("usernumber = "+user.getUserNumber());
				System.out.println("username = "+user.getUserName());
				System.out.println("userenabled = "+user.getUserEnabled());
				System.out.println("userstatus = "+user.getUserStatus());
				System.out.println("userrole = "+user.getUserRole());
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getuserbyemailtest error"+e);
    		b=true;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getuserbystatustest(){
    	System.out.println("getuserbystatustest begins");
    	boolean b=false;
    	UserDAO userdao = new UserDAOImpl();
    	try{
    		List<User> list = userdao.getUserByStatus("yes","niit@niit.com");
    		if(list!=null){
    	    	Iterator item = list.iterator();
    	    	while(item.hasNext()){
    	    		User user = (User)item.next();
    	    		System.out.println("useremail = "+user.getUserEmail());
    				System.out.println("userpassword = "+user.getUserPassword());
    				System.out.println("useraddress = "+user.getUserAddress());
    				System.out.println("usernumber = "+user.getUserNumber());
    				System.out.println("username = "+user.getUserName());
    				System.out.println("userenabled = "+user.getUserEnabled());
    				System.out.println("userstatus = "+user.getUserStatus());
    				System.out.println("userrole = "+user.getUserRole());
    				System.out.println("************************************************");
    	    	}
    	    }
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getuserbystatustest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void deleteusertest(){
    	System.out.println("deleteusertest begins");
    	try{
    		User user = new User();
    		UserDAO userdao = new UserDAOImpl();
    		user.setUserEmail("niit7@niit.com");
    		boolean b = userdao.deleteUser(user);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deleteusertest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updateusertest(){
    	System.out.println("updateusertest begins");
    	try{
    		User user = new User();
    		UserDAO userdao = new UserDAOImpl();
    		boolean b=userdao.updateUser(user);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updateusertest error"+e);
    	}
    }
    @Ignore
    @Test
    public void changeuserstatustest(){
    	System.out.println("changeuserstatustest begins");
    	UserDAO userdao = new UserDAOImpl();
    	try{
    		String UserEmail = "niit@niit.com";
    		String UserStatus = "yes";
    		boolean b = userdao.changeUserStatus(UserEmail, UserStatus);
    		System.out.println("status changed");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("changeuserstatustest error"+e);
    	}
    }
    @Ignore
    @Test
    public void getallotherusertest(){
    	System.out.println("getallotherusertest begins");
    	UserDAO userdao = new UserDAOImpl();
    	try{
    	List<User> list = (List) userdao.getallOtherUser("niit@niit.com");
    	if(list!=null){
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			User user = (User)item.next();
    			System.out.println("useremail = "+user.getUserEmail());
				System.out.println("userpassword = "+user.getUserPassword());
				System.out.println("useraddress = "+user.getUserAddress());
				System.out.println("usernumber = "+user.getUserNumber());
				System.out.println("username = "+user.getUserName());
				System.out.println("userenabled = "+user.getUserEnabled());
				System.out.println("userstatus = "+user.getUserStatus());
				System.out.println("userrole = "+user.getUserRole());
				System.out.println("************************************************");
    		}
    	}
    	}
    	catch(Exception e){
    		System.out.println("getallotherusertest error"+e);
    	}
    }
}