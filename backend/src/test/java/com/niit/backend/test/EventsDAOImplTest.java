package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.EventsDAO;
import com.niit.backend.daoimpl.EventsDAOImpl;
import com.niit.backend.model.Events;

public class EventsDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@Ignore
	@Test
	public void addeventstest() {
		System.out.println("addeventstest begins");
		try{
			Events events = new Events();
			events.setEventsName("Dancing Competition");
			events.setEventsVenue("Kolkata");
			EventsDAO eventsdao = new EventsDAOImpl();
			boolean b=eventsdao.addEvents(events);
			System.out.println("data added");
			assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addeventstest error"+e);
		}
	}
    @Ignore
    @Test
    public void getallEventstest(){
    	System.out.println("getalleventstest begins");
    	boolean b=false;
    	EventsDAO eventsdao = new EventsDAOImpl();
    	try{
    		List<Events>list=eventsdao.getallEvents();
    		if(list!=null){
    			Iterator item=list.iterator();
    			while(item.hasNext()){
    				Events events = (Events)item.next();
    				System.out.println("eventsid = "+events.getEventsId());
    				System.out.println("eventsdateandtime = "+events.getEventsDate());
    				System.out.println("eventsname = "+events.getEventsName());
    				System.out.println("eventsvenue = "+events.getEventsVenue());
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getalleventstest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void geteventsbyidtest(){
    	System.out.println("geteventsbyidtest begins");
    	boolean b=false;
    	EventsDAO eventsdao = new EventsDAOImpl();
    	try{
    		Events events = eventsdao.getEventsById(82);
    		if(events!=null){
    			System.out.println("eventsid = "+events.getEventsId());
				System.out.println("eventsdateandtime = "+events.getEventsDate());
				System.out.println("eventsname = "+events.getEventsName());
				System.out.println("eventsvenue = "+events.getEventsVenue());
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("geteventsbyidtest error"+e);
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void deleteeventstest(){
    	System.out.println("deleteeventstest begins");
    	try{
    		Events events = new Events();
    		EventsDAO eventsdao = new EventsDAOImpl();
    		events.setEventsId(82);
    		boolean b=eventsdao.deleteEvents(events);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deleteeventstest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updateeventstest(){
    	System.out.println("updateeventstest begins");
    	try{
    		Events events = new Events();
    		EventsDAO eventsdao = new EventsDAOImpl();
    		boolean b=eventsdao.updateEvents(events);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updateeventstest error"+e);
    	}
    }

}
