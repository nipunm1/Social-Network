package com.middleware.controller;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.backend.dao.UserMultimediaDAO;
import com.niit.backend.daoimpl.UserMultimediaDAOImpl;
import com.niit.backend.model.UserMultimedia;


@RestController
public class UserMultimediaController {
	
	@RequestMapping(value="/addUserMultimedia", method=RequestMethod.POST)
	public JSONObject addUserMultimedia(@RequestParam CommonsMultipartFile file[],HttpSession session,HttpServletRequest req){
		{
			System.out.println("***************************************************");
			System.out.println("add usermultimedia middleware controller");
			System.out.println("***************************************************");
			try{
				UserMultimedia usermultimedia = new UserMultimedia();
				UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
				String useremail = req.getParameter("useremail");
				usermultimedia.setUserEmail(useremail);
				String filename;
				int id=0;
                UserMultimediaDAO Usermultimediadao = new UserMultimediaDAOImpl();
                List<UserMultimedia>list=Usermultimediadao.getallUserMultimedia();
				Iterator item = list.iterator();
				while(item.hasNext()){
						UserMultimedia Usermultimedia =(UserMultimedia)item.next();
						id=Usermultimedia.getUserMultimediaId();
						System.out.println("id = "+id);
				}
				for(CommonsMultipartFile obj : file)
				{
					filename = obj.getOriginalFilename();
					try{
					String filename1[] = filename.split("\\.");
					String filenames = filename1[0]+id+"."+filename1[1];
					byte barr[]=obj.getBytes();  
					BufferedOutputStream bout=new BufferedOutputStream(  
		            new FileOutputStream("E:/project/project2/frontend/src/main/webapp/resources/uploadfiles"+"/"+filenames));
		    	    bout.write(barr);  
			        bout.flush();  
				    bout.close();  
					if(filenames.endsWith(".jpg")||filenames.endsWith(".png")||filenames.endsWith(".jpeg")||filenames.endsWith(".cr2")||filenames.endsWith(".JPG")||filenames.endsWith(".PNG")||filenames.endsWith(".JPEG")||filenames.endsWith(".CR2"))
					{
						usermultimedia.setUserMultimediaImage(filenames);
					}
					else if(filenames.endsWith(".mp3")||filenames.endsWith(".MP3")){
						usermultimedia.setUserMultimediaAudio(filenames);
					}
					else if(filenames.endsWith(".mp4")||filenames.endsWith(".mov")||filenames.endsWith(".MP4")||filenames.endsWith(".MOV")){
						usermultimedia.setUserMultimediaVideo(filenames);
					}
					else{
					    
					}
					}
					catch(Exception e){
				        System.out.println("error in finding path "+e);
				   }
				}
				usermultimediadao.addUserMultimedia(usermultimedia);
				System.out.println("data added");
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse("data added");
				return json;
			}
			catch(Exception e){
				System.out.println("addusermultimediamiddleware error"+e);
				return null;
			}
		}
	}
    @GetMapping(value="/allUserMultimedia")
    public List<UserMultimedia>getAllUserMultimedia(HttpServletRequest req){
    	System.out.println("***********************************************");
    	System.out.println("all usermultimedia middleware controller");
    	System.out.println("***********************************************");
    	try{
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		List<UserMultimedia>list=usermultimediadao.getallUserMultimedia();
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			UserMultimedia usermultimedia = (UserMultimedia)item.next();
    			System.out.println("useremail = "+usermultimedia.getUserEmail());
    			System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
    			System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
    			System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
    			System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
    			System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
    			System.out.println("*******************************************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getallusermultimediamiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/usermultimediaById")
    public UserMultimedia getUserMultimediaById(@RequestParam("UserMultimediaId") int UserMultimediaId){
    	System.out.println("*****************************************************");
    	System.out.println("usermultimedia by id middleware controller");
    	System.out.println("*****************************************************");
    	try{
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		UserMultimedia usermultimedia = usermultimediadao.getUserMultimediaById(UserMultimediaId);
    		if(usermultimedia!=null){
    			System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
    			System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
    			System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
    			System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
    			System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
    		}
    		return usermultimedia;
    	}
    	catch(Exception e){
    		System.out.println("getusermultimediabyidmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/deleteUserMultimedia")
    public JSONObject DeleteUserMultimedia(HttpServletRequest req){
    	System.out.println("*********************************************");
    	System.out.println("delete usermultimedia middleware controller");
    	System.out.println("*********************************************");
    	String str = req.getParameter("usermultimediaid");
    	int usermultimediaid = Integer.parseInt(str);
    	try{
    		UserMultimedia usermultimedia = new UserMultimedia();
    		usermultimedia.setUserMultimediaId(usermultimediaid);
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		usermultimediadao.deleteUserMultimedia(usermultimedia);
    		System.out.println("data deleted");
    		String str1 = "data deleted from table";
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str1);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("deleteusermultimediamiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/updateUserMultimedia")
    public JSONObject UpdateUserMultimedia(HttpServletRequest req){
    	System.out.println("**************************************************");
    	System.out.println("update usermultimedia middleware controller");
    	System.out.println("**************************************************");
    	String str = req.getParameter("usermultimediaid");
    	int usermultimediaid = Integer.parseInt(str);
    	try{
    		UserMultimedia usermultimedia = new UserMultimedia();
    		usermultimedia.setUserMultimediaId(usermultimediaid);
    		usermultimedia.setUserMultimediaImage("image5");
    		usermultimedia.setUserMultimediaAudio("audio5");
    		usermultimedia.setUserMultimediaVideo("video5");
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		usermultimediadao.updateUserMultimedia(usermultimedia);
    		System.out.println("data updated");
    		String str1 = "data updated from table";
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse(str1);
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("updateusermultimediamiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/usermultimediaByUserEmail")
    public List<UserMultimedia>getUserMultimediaByUserEmail(@RequestParam("useremail")String UserEmail){
    	System.out.println("**************************************************");
    	System.out.println("usermultimedia by useremail middleware controller");
    	System.out.println("**************************************************");
    	try{
    		UserMultimediaDAO usermultimediadao=new UserMultimediaDAOImpl();
    		List<UserMultimedia>list=usermultimediadao.getUserMultimediaByUserEmail(UserEmail);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				UserMultimedia usermultimedia = (UserMultimedia)item.next();
    				System.out.println("useremail = "+usermultimedia.getUserEmail());
        			System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
        			System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
        			System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
        			System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
        			System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
        			System.out.println("*******************************************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getusermultimediabyuseremailmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/otherUserMultimediaByUserEmail")
    public List<UserMultimedia>getOtherUserMultimediaByUserEmail(@RequestParam("useremail")String UserEmail){
    	System.out.println("***********************************************************");
    	System.out.println("other usermultimedia by useremail middleware controller");
    	System.out.println("***********************************************************");
    	try{
    		UserMultimediaDAO usermultimediadao=new UserMultimediaDAOImpl();
    		List<UserMultimedia>list=usermultimediadao.getOtherUserMultimediaByUserEmail(UserEmail);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				UserMultimedia usermultimedia = (UserMultimedia)item.next();
    				System.out.println("useremail = "+usermultimedia.getUserEmail());
        			System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
        			System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
        			System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
        			System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
        			System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
        			System.out.println("*******************************************************************");
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getotherusermultimediabyuseremailmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/addUserMultimediaLike")
    public JSONObject AddUserMultimediaLike(@RequestParam("usermultimediaid")int UserMultimediaId){
    	System.out.println("*********************************************");
    	System.out.println("add usermultimedia like middleware controller");
    	System.out.println("*********************************************");
    	try{
    	   UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    	   UserMultimedia usermultimedia = usermultimediadao.addUserMultimediaLikes(UserMultimediaId);
    	   if(usermultimedia!=null){
    		   System.out.println("one like added");
    	   }
    	   JSONParser parser = new JSONParser();
		   JSONObject json = (JSONObject) parser.parse("one like added");
		   return json;
    	}
    	catch(Exception e){
        	System.out.println("addusermultimedialikemiddleware error"+e.toString());	
        	return null;	
    	}
    }
    @GetMapping(value="/addUserMultimediaDislike")
    public JSONObject AddUserMultimediaDislike(@RequestParam("usermultimediaid")int UserMultimediaId){
    	System.out.println("***************************************************");
    	System.out.println("add usermultimedia dislike middleware controller");
    	System.out.println("***************************************************");
    	try{
    	   UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
     	   UserMultimedia usermultimedia = usermultimediadao.addUserMultimediaDislikes(UserMultimediaId);
     	   if(usermultimedia!=null){
     		  System.out.println("one dislike added");
     	   }
    	   JSONParser parser = new JSONParser();
 		   JSONObject json = (JSONObject) parser.parse("one dislike added");
 		   return json;
    	}
    	catch(Exception e){
    		System.out.println("addusermultimediadislikemiddleware error"+e.toString());
    		return null;
    	}
    }
}