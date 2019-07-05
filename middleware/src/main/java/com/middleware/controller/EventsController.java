package com.middleware.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.EventsDAO;
import com.niit.backend.daoimpl.EventsDAOImpl;
import com.niit.backend.model.Events;

@RestController
public class EventsController {
    @GetMapping(value="/addEvents")
	public String AddEvents(HttpServletRequest req){
    	System.out.println("**********************************");
    	System.out.println("add events middleware controller");
    	System.out.println("**********************************");
    	
    	String eventsname = req.getParameter("eventsname");
    	String eventsvenue = req.getParameter("eventsvenue");
    	
    	Events events = new Events();
    	events.setEventsName(eventsname);
    	events.setEventsVenue(eventsvenue);
    	
    	try{
    		EventsDAO eventsdao = new EventsDAOImpl();
    		eventsdao.addEvents(events);
    		System.out.println("eventsname = "+eventsname);
    		System.out.println("eventsvenue = "+eventsvenue);
    		return "data inserted in events table";
    	}
    	catch(Exception e){
    		System.out.println("addeventsmiddleware error"+e.toString());
    		return null;
    	}
	}
    @GetMapping(value="/allEvents")
    public List<Events>getAllEvents(HttpServletRequest req){
    	System.out.println("*********************************");
    	System.out.println("all events middleware controller");
    	System.out.println("*********************************");
    	try{
    		EventsDAO eventsdao = new EventsDAOImpl();
    		List<Events>list=eventsdao.getallEvents();
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			Events events = (Events)item.next();
    			System.out.println("eventsid = "+events.getEventsId());
    			System.out.println("eventsdate = "+events.getEventsDate());
    			System.out.println("eventsname = "+events.getEventsName());
    			System.out.println("eventsvenue = "+events.getEventsVenue());
    			System.out.println("********************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("alleventsmiddleware error"+e.toString());
    		return null;	
    	}
	  }
    @GetMapping(value="/eventsById")
    public Events getEventsById(@RequestParam("EventsId")int EventsId){
    	System.out.println("*********************************************");
    	System.out.println("events by id middleware controller");
    	System.out.println("*********************************************");
    	try{
    		EventsDAO eventsdao = new EventsDAOImpl();
    		Events events = eventsdao.getEventsById(EventsId);
    		if(events!=null){
    			System.out.println("eventsid = "+events.getEventsId());
    			System.out.println("eventsdate = "+events.getEventsDate());
    			System.out.println("eventsname = "+events.getEventsName());
    			System.out.println("eventsvenue = "+events.getEventsVenue());
    		}
    		return events;
    	}
    	catch(Exception e){
    		System.out.println("geteventsbyidmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/deleteEvents")
    public String DeleteEvents(HttpServletRequest req){
    	System.out.println("******************************************");
    	System.out.println("delete events middleware controller");
    	System.out.println("******************************************");
    	String str = req.getParameter("eventsid");
    	int eventsid = Integer.parseInt(str);
    	try{
    	Events events = new Events();
    	events.setEventsId(eventsid);
    	EventsDAO eventsdao = new EventsDAOImpl();
    	eventsdao.deleteEvents(events);
    	System.out.println("data deleted");
    	return "data deleted from table";	
    	}
    	catch(Exception e){
    		System.out.println("deleteeventsmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/updateEvents")
    public String UpdateEvents(HttpServletRequest req){
    	System.out.println("************************************");
    	System.out.println("update events middleware controller");
    	System.out.println("************************************");
    	String str = req.getParameter("eventsid");
    	int eventsid = Integer.parseInt(str);
    	try{
    		Events events = new Events();
    		events.setEventsId(eventsid);
    		events.setEventsName("Dancing Compitition");
    		events.setEventsVenue("Mumbai");
    		EventsDAO eventsdao = new EventsDAOImpl();
    		eventsdao.updateEvents(events);
    		System.out.println("data updated");
    		return "data updated from table";
    	}
    	catch(Exception e){
    		System.out.println("updateeventsmiddware error"+e.toString());
    		return null;	
    	}
    }
}
