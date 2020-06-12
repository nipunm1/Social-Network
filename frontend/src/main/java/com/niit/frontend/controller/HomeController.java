package com.niit.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value="/",method=RequestMethod.GET)
	public String FrontendHome(){
		System.out.println("*********************************");
		System.out.println("frontend home controller");
		System.out.println("*********************************");
		
		return "home";
	}
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String Register(){
    	System.out.println("*********************************");
		System.out.println("register controller");
		System.out.println("*********************************");
		
    	return "register";
    }
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String Login(){
    	System.out.println("*********************************");
		System.out.println("login controller");
		System.out.println("*********************************");
		
    	return "login";
    }
    @RequestMapping(value="/profile",method=RequestMethod.GET)
    public String Profile(){
    	System.out.println("**********************************");
    	System.out.println("profile controller");
    	System.out.println("**********************************");
    	
    	return "profile";
    }
    @RequestMapping(value="/blog",method=RequestMethod.GET)
    public String Blog(){
    	System.out.println("**************************************");
    	System.out.println("blog controller");
    	System.out.println("**************************************");
    	
    	return "blog";
    }
    @RequestMapping(value="/allblog",method=RequestMethod.GET)
    public String AllBlog(){
    	System.out.println("**************************************");
    	System.out.println("all blog controller");
    	System.out.println("**************************************");
    	
    	return "allblog";
    }
    @RequestMapping(value="/allusermultimedia",method=RequestMethod.GET)
    public String AllUserMultimedia(){
    	System.out.println("**************************************");
    	System.out.println("all usermultimedia controller");
    	System.out.println("**************************************");
    	
    	return "allusermultimedia"; 
    }
    @RequestMapping(value="/h",method=RequestMethod.GET)
    public String HomeProfile(){
    	System.out.println("**************************************");
    	System.out.println("home profile controller");
    	System.out.println("**************************************");
    	
    	return "profile";
    }
    @RequestMapping(value="/myprofile",method=RequestMethod.GET)
    public String MyProfile(){
    	System.out.println("****************************************");
    	System.out.println("my profile controller");
    	System.out.println("****************************************");
    	
    	return "myprofile";
    }
    @RequestMapping(value="/addfriends",method=RequestMethod.GET)
    public String AddFriends(){
    	System.out.println("********************************************");
    	System.out.println("add friends controller");
    	System.out.println("********************************************");
    	
    	return "addfriends";
    }
    @RequestMapping(value="/friends",method=RequestMethod.GET)
    public String Friends(){
    	System.out.println("*********************************************");
    	System.out.println("friends controller");
    	System.out.println("*********************************************");
    	
    	return "friends";
    }
    @RequestMapping(value="/chat",method=RequestMethod.GET)
    public String Chat(){
    	System.out.println("*********************************************");
    	System.out.println("chat controller");
    	System.out.println("*********************************************");
    	
    	return "chat";
    }
}