package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.MessageDAO;
import com.niit.backend.daoimpl.MessageDAOImpl;
import com.niit.backend.model.Message;

public class MessageDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    @Ignore
	@Test
	public void addmessagetest() {
		System.out.println("addmessagetest begins");
		try{
			Message message = new Message();
			message.setMessageFrom("vinay");
			message.setMessageText("opi");
			MessageDAO messagedao = new MessageDAOImpl();
			boolean b=messagedao.addMessage(message);
			System.out.println("data added");
			assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addmessagetest error"+e);
		}
	}
    @Ignore
    @Test
    public void getallmessagetest(){
    	System.out.println("getallmessagetest begins");
    	boolean b=false;
    	MessageDAO messagedao=new MessageDAOImpl();
    	try{
    		List<Message>list=messagedao.getallMessage();
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				Message message = (Message)item.next();
    				System.out.println("messageid = "+message.getMessageId());
    				System.out.println("messagetext = "+message.getMessageText());
    				System.out.println("messagefrom = "+message.getMessageFrom());
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getallmessagetest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getmessagebyidtest(){
    	System.out.println("getmessagebyidtest begins");
    	boolean b=false;
    	MessageDAO messagedao = new MessageDAOImpl();
    	try{
    		b=true;
    		Message message = messagedao.getMessageById(57);
    		if(message!=null){
    			System.out.println("messageid = "+message.getMessageId());
				System.out.println("messagetext = "+message.getMessageText());
				System.out.println("messagefrom = "+message.getMessageFrom());
    		}
    	}
    	catch(Exception e){
    		System.out.println("getmessagebyidtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void deletemessagetest(){
    	System.out.println("deletemessagetest begins");
    	try{
    		Message message = new Message();
    		MessageDAO messagedao = new MessageDAOImpl();
    		message.setMessageId(58);
    		boolean b=messagedao.deleteMessage(message);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deletemessagetest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updatemessagetest(){
    	System.out.println("updatemessagetest begins");
    	try{
    		Message message = new Message();
    		MessageDAO messagedao = new MessageDAOImpl();
    		boolean b = messagedao.updateMessage(message);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updatemessagetest error"+e);
    	}
    }

}
