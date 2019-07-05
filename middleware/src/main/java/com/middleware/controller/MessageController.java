package com.middleware.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.MessageDAO;
import com.niit.backend.daoimpl.MessageDAOImpl;
import com.niit.backend.model.Message;

@RestController
public class MessageController {
    @GetMapping(value="/addMessage")
	public String AddMessage(HttpServletRequest req){
    	System.out.println("******************************************");
    	System.out.println("add message middleware controller");
    	System.out.println("******************************************");
    	
    	String messagefrom = req.getParameter("messagefrom");
    	String messagetext = req.getParameter("messagetext");
    	
    	Message message = new Message();
    	message.setMessageFrom(messagefrom);
    	message.setMessageText(messagetext);
    	try{
    		MessageDAO messagedao = new MessageDAOImpl();
    		messagedao.addMessage(message);
    		System.out.println("messagefrom = "+messagefrom);
    		System.out.println("messagetext = "+messagetext);
    		return "data inserted in message table";
    	}
    	catch(Exception e){
    		System.out.println("addmessagemiddleware error"+e.toString());
    		return null;	
    	}
	}
    @GetMapping(value="/allMessage")
    public List<Message> getAllMessage(HttpServletRequest req){
    	System.out.println("********************************************");
    	System.out.println("all message middleware controller");
    	System.out.println("********************************************");
    	try{
    		MessageDAO messagedao = new MessageDAOImpl();
    		List<Message>list=messagedao.getallMessage();
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			Message message = (Message)item.next();
    			System.out.println("messageid = "+message.getMessageId());
    			System.out.println("messagefrom = "+message.getMessageFrom());
    			System.out.println("messagetext = "+message.getMessageText());
    			System.out.println("********************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getallmessagemiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/messageById")
    public Message getMessageById(@RequestParam("MessageId")int MessageId){
    	System.out.println("******************************************");
    	System.out.println("message by id middleware controller");
    	System.out.println("******************************************");
    	try{
    		MessageDAO messagedao = new MessageDAOImpl();
    		Message message = messagedao.getMessageById(MessageId);
    		if(message!=null){
    			System.out.println("messageid = "+message.getMessageId());
    			System.out.println("messagefrom = "+message.getMessageFrom());
    			System.out.println("messagetext = "+message.getMessageText());
    		}
    		return message;
    	}
    	catch(Exception e){
    		System.out.println("getmessagebyidmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/deleteMessage")
    public String DeleteMessage(HttpServletRequest req){
    	System.out.println("********************************************");
    	System.out.println("delete message middleware controller");
    	System.out.println("********************************************");
    	String str = req.getParameter("messageid");
    	int messageid = Integer.parseInt(str);
    	try{
    		Message message = new Message();
    		message.setMessageId(messageid);
    		MessageDAO messagedao = new MessageDAOImpl();
    		messagedao.deleteMessage(message);
    		System.out.println("data deleted");
    		return "data deleted from table";
    	}
    	catch(Exception e){
    		System.out.println("deletemessagemiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/updateMessage")
    public String UpdateMessage(HttpServletRequest req){
    	System.out.println("********************************************");
    	System.out.println("update message middleware controller");
    	System.out.println("********************************************");
    	String str = req.getParameter("messageid");
    	int messageid = Integer.parseInt(str);
    	try{
    		Message message = new Message();
    		message.setMessageId(messageid);
    		message.setMessageFrom("sahil");
    		message.setMessageText("qrst");
    		MessageDAO messagedao = new MessageDAOImpl();
    		messagedao.updateMessage(message);
    		System.out.println("data updated");
    		return "data updated from table";
    	}
    	catch(Exception e){
    		System.out.println("updatemessagemiddleware error"+e.toString());
    		return null;
    	}
    }
}
