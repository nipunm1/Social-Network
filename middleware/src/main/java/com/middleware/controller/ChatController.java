package com.middleware.controller;

import java.util.List;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.ChatDAO;
import com.niit.backend.daoimpl.ChatDAOImpl;
import com.niit.backend.model.Chat;
@RestController
public class ChatController {
    @GetMapping(value="/addChat")
	public JSONObject AddChat(HttpServletRequest req){
    	System.out.println("******************************");
    	System.out.println("add chat middleware controller");
    	System.out.println("******************************");
    	String chatmessage = req.getParameter("chatmessage");
    	String chatto = req.getParameter("chatto");
    	String chatfrom = req.getParameter("chatfrom");
   
    	Chat chat = new Chat();
    	chat.setChatMessage(chatmessage);
    	chat.setChatFrom(chatfrom);
    	chat.setChatTo(chatto);
    	
    	try{
    		ChatDAO chatdao = new ChatDAOImpl();
    		chatdao.addChat(chat);
    		System.out.println("chatmessage = "+chatmessage);
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject) parser.parse("chatadded");
    		return json;
    	}
    	catch(Exception e){
    		System.out.println("addchatmiddleware error"+e.toString());
    		return null;	
    	}
	}
    @GetMapping(value="/allChat")
    public List<Chat>getAllChat(HttpServletRequest req){
    	System.out.println("*******************************************");
    	System.out.println("all chat middleware controller");
    	System.out.println("*******************************************");
    	try{
    		ChatDAO chatdao = new ChatDAOImpl();
    		List<Chat>list=chatdao.getallChat();
    		Iterator item=list.iterator();
    		while(item.hasNext()){
    			Chat chat = (Chat)item.next();
    			System.out.println("chatid = "+chat.getChatId());
    			System.out.println("chatdate = "+chat.getChatDate());
    			System.out.println("chatmessage = "+chat.getChatMessage());
    			System.out.println("********************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getallchatmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/chatById")
    public Chat getChatById(@RequestParam("ChatId")int ChatId){
    	System.out.println("*****************************************");
    	System.out.println("chat by id middleware controller");
    	System.out.println("*****************************************");
    	try{
    		ChatDAO chatdao = new ChatDAOImpl();
    		Chat chat = chatdao.getChatById(ChatId);
    		if(chat!=null){
    			System.out.println("chatid = "+chat.getChatId());
    			System.out.println("chatdate = "+chat.getChatDate());
    			System.out.println("chatmessage = "+chat.getChatMessage());
    		}
    		return chat;
    	}
    	catch(Exception e){
    		System.out.println("getchatbyidmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/deleteChat")
    public String DeleteChat(HttpServletRequest req){
    	System.out.println("****************************************");
    	System.out.println("delete chat middleware controller");
    	System.out.println("****************************************");
    	String str = req.getParameter("chatid");
    	int chatid = Integer.parseInt(str);
    	try{
    		Chat chat = new Chat();
    		chat.setChatId(chatid);
    		ChatDAO chatdao = new ChatDAOImpl();
    		chatdao.deleteChat(chat);
    		System.out.println("data deleted");
    		return "data deleted by table";
    	}
    	catch(Exception e){
    		System.out.println("deletechatmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/updateChat")
    public String UpdateChat(HttpServletRequest req){
    	System.out.println("****************************************");
    	System.out.println("update chat middleware controller");
    	System.out.println("****************************************");
    	String str = req.getParameter("chatid");
    	int chatid = Integer.parseInt(str);
    	try{
    		Chat chat = new Chat();
    		chat.setChatId(chatid);
    		chat.setChatMessage("lkj");
    		ChatDAO chatdao = new ChatDAOImpl();
    		chatdao.updateChat(chat);
    		System.out.println("data updated");
    		return "data updated from table";
    	}
    	catch(Exception e){
    		System.out.println("updatechatmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/getChatFromFriend")
    public List<Chat>getChatFromFriend(@RequestParam("chatfrom")String ChatFrom,@RequestParam("chatto")String ChatTo){
    	System.out.println("*****************************************************");
    	System.out.println("getchatfromfriend middleware controller");
    	System.out.println("*****************************************************");
    	 try{
    		ChatDAO chatdao = new ChatDAOImpl();
    		List<Chat>list = chatdao.getChatFromFriend(ChatTo, ChatFrom);
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Chat chat = (Chat)item.next();
    				System.out.println("chatid = "+chat.getChatId());
    				System.out.println("chatfrom = "+chat.getChatFrom());
    				System.out.println("chatto = "+chat.getChatTo());
    				System.out.println("chatmessage = "+chat.getChatMessage());
    				System.out.println("chatdate = "+chat.getChatDate());
    			}
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getchatfromfriendmiddleware error "+e.toString());
    		return null;
    	}
    }
}