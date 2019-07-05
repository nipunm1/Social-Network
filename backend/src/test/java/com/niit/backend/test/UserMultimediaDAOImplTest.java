package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.UserMultimediaDAO;
import com.niit.backend.daoimpl.UserMultimediaDAOImpl;
import com.niit.backend.model.UserMultimedia;

public class UserMultimediaDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    
	@Test
	public void addusermultimediatest() {
		System.out.println("addusermultimediatest begins");
		try{
			UserMultimedia usermultimedia=new UserMultimedia();
			usermultimedia.setUserEmail("niit@niit.com");
			usermultimedia.setUserMultimediaAudio("audio2");
			usermultimedia.setUserMultimediaImage("image2");
			usermultimedia.setUserMultimediaVideo("video2");
			usermultimedia.setUserMultimediaLikes(01);
			usermultimedia.setUserMultimeidaDislikes(01);
			UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
			boolean b = usermultimediadao.addUserMultimedia(usermultimedia);
			System.out.println("data added");
			assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addusermultimediatest error");
		}
		
	}
    @Ignore
    @Test
    public void getallusermultimediatest(){
    	System.out.println("getallusermultimediatest begins");
    	boolean b=false;
    	UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    	try{
    		List<UserMultimedia>list=usermultimediadao.getallUserMultimedia();
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				UserMultimedia usermultimedia = (UserMultimedia)item.next();
    				System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
    				System.out.println("useremail = "+usermultimedia.getUserEmail());
    				System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
    				System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
    				System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
    				System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
    				System.out.println("********************************************************************");
    			}
    			b=true;
    		}
    	}
    	catch(Exception e){
    		System.out.println("getallusermultimediatest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getusermultimediabyidtest(){
    	System.out.println("getusermultimediabyidtest begins");
    	boolean b=false;
    	UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    	try{
    		UserMultimedia usermultimedia = usermultimediadao.getUserMultimediaById(56);
    		if(usermultimedia!=null){
    			System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
				System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
				System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
				System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
				System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
			}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getusermultimediabyidtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void deleteusermultimediatest(){
    	System.out.println("deleteusermultimediatest begins");
    	try{
    		UserMultimedia usermultimedia = new UserMultimedia();
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		usermultimedia.setUserMultimediaId(65);
    		boolean b=usermultimediadao.deleteUserMultimedia(usermultimedia);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deleteusermultimediatest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updateusermultimediatest(){
    	System.out.println("updateusermultimediatest begins");
    	try{
    		UserMultimedia usermultimedia = new UserMultimedia();
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		boolean b=usermultimediadao.updateUserMultimedia(usermultimedia);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updateusermultimediatest error"+e);
    	}
    }
    @Ignore
    @Test
    public void getusermultimediabyuseremailtest(){
    	System.out.println("getusermultimediabyuseremailtest begins");
    	boolean b=false;
    	UserMultimediaDAO usermultimediadao=new UserMultimediaDAOImpl();
    	try{
    		List<UserMultimedia>list=usermultimediadao.getUserMultimediaByUserEmail("niit@niit.com");
    		if(list!=null){
    			Iterator item=list.iterator();
    			while(item.hasNext()){
    				UserMultimedia usermultimedia = (UserMultimedia)item.next();
    				System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
    				System.out.println("useremail = "+usermultimedia.getUserEmail());
    				System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
    				System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
    				System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
    				System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
    				System.out.println("********************************************************************");
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getusermultimediabyuseremailtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getotherusermultimediabyuseremailtest(){
    	System.out.println("getotherusermultimediabyuseremailtest begins");
    	boolean b=false;
    	UserMultimediaDAO usermultimediadao=new UserMultimediaDAOImpl();
    	try{
    		List<UserMultimedia>list=usermultimediadao.getOtherUserMultimediaByUserEmail("nipunmiglani@gmail.com");
    		if(list!=null){
    			Iterator item=list.iterator();
    			while(item.hasNext()){
    				UserMultimedia usermultimedia = (UserMultimedia)item.next();
    				System.out.println("usermultimediaid = "+usermultimedia.getUserMultimediaId());
    				System.out.println("useremail = "+usermultimedia.getUserEmail());
    				System.out.println("usermultimediaimage = "+usermultimedia.getUserMultimediaImage());
    				System.out.println("usermultimediaaudio = "+usermultimedia.getUserMultimediaAudio());
    				System.out.println("usermultimediavideo = "+usermultimedia.getUserMultimediaVideo());
    				System.out.println("usermultimediatran = "+usermultimedia.getUserMultimediaTran());
    				System.out.println("********************************************************************");
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getotherusermultimediabyuseremailtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void addusermultimedialikestest(){
    	System.out.println("addusermultimedialikestest begins");
    	boolean b=false;
    	try{
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		UserMultimedia usermultimedia = usermultimediadao.addUserMultimediaLikes(01);
    		if(usermultimedia!=null){
    			System.out.println("one like added");
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("addusermultimedialikestest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void addusermultimediadislikestest(){
    	System.out.println("addusermultimediadislikestest begins");
    	boolean b=false;
    	try{
    		UserMultimediaDAO usermultimediadao = new UserMultimediaDAOImpl();
    		UserMultimedia usermultimedia = usermultimediadao.addUserMultimediaDislikes(01);
    		if(usermultimedia!=null){
    			System.out.println("one dislike added");
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("addusermultimediadislikestest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
}