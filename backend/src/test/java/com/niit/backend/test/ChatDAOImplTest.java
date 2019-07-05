package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.ChatDAO;
import com.niit.backend.daoimpl.ChatDAOImpl;
import com.niit.backend.model.Chat;

public class ChatDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    @Ignore
	@Test
	public void addchattest() {
		System.out.println("addchattest begins");
		try{
			Chat chat = new Chat();
			chat.setChatMessage("XYZ");
			chat.setChatTo("niit1@gmail.com");
			chat.setChatFrom("niit@niit.com");
			ChatDAO chatdao = new ChatDAOImpl();
			boolean b = chatdao.addChat(chat);
			System.out.println("data added");
			assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addchattest error"+e);
		}
	}
    @Ignore
    @Test
    public void getallchattest(){
    	System.out.println("getallchattest begins");
    	boolean b=false;
    	ChatDAO chatdao = new ChatDAOImpl();
    	try{
    		List<Chat>list=chatdao.getallChat();
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Chat chat = (Chat)item.next();
    				System.out.println("ChatId = "+chat.getChatId());
    				System.out.println("ChatDate = "+chat.getChatDate());
    				System.out.println("ChatMessage = "+chat.getChatMessage());
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getallchattest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getchatbyidtest(){
    	System.out.println("getchatbyidtest begins");
    	boolean b=false;
    	ChatDAO chatdao = new ChatDAOImpl();
    	try{
    		Chat chat = chatdao.getChatById(88);
    		if(chat!=null){
    			System.out.println("ChatId = "+chat.getChatId());
				System.out.println("ChatDate = "+chat.getChatDate());
				System.out.println("ChatMessage = "+chat.getChatMessage());
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getchatbyidtest error"+e);
    		b=false;
    	}
    }
    @Ignore
    @Test
    public void deletechattest(){
    	System.out.println("deletechattest begins");
    	try{
    		Chat chat = new Chat();
    		ChatDAO chatdao = new ChatDAOImpl();
    		chat.setChatId(88);
    		boolean b=chatdao.deleteChat(chat);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deletechattest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updatechattest(){
    	System.out.println("updatechattest begins");
    	try{
    		Chat chat = new Chat();
    		ChatDAO chatdao = new ChatDAOImpl();
    		boolean b=chatdao.updateChat(chat);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updatechattest error"+e);
    	}
    }
    @Ignore
    @Test
    public void getchatfromfriendtest(){
    System.out.println("getchatfromfriendtest begins");
    boolean b=false;
    ChatDAO chatdao = new ChatDAOImpl();
    try{
    	List<Chat>list=chatdao.getChatFromFriend("niit@niit.com","nipun@niit.com");
    	if(list!=null){
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			Chat chat = (Chat)item.next();
    			System.out.println("chatid = "+chat.getChatId());
    			System.out.println("chatdate = "+chat.getChatDate());
    			System.out.println("chatfrom = "+chat.getChatFrom());
    			System.out.println("chatto = "+chat.getChatTo());
    			System.out.println("chatmessage = "+chat.getChatMessage());
    		}
    	}
    	b=true;
    }
    catch(Exception e){
    	System.out.println("getchatfromfriendtest error "+e);
    	b=false;
    }
    assertTrue(b);
    }
}
