package com.niit.backend.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.EventsDAO;
import com.niit.backend.model.Events;

public class EventsDAOImpl implements EventsDAO{

	public boolean addEvents(Events events) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			events.setEventsDate(df.format(date));
			session.save(events);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addeventsdaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean deleteEvents(Events events) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(events);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deleteeventsdaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean updateEvents(Events events) {
		EventsDAO eventsdao = new EventsDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			//events=eventsdao.getEventsById(81);
			events.setEventsDate(df.format(date));
			//events.setEventsName("Drawing Compitition");
			//events.setEventsVenue("Delhi");
			session.update(events);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updateeventsdaoimpl error"+e);
			return false;	
		}
		
	}

	public List<Events> getallEvents() {
		List<Events>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from Events").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
				System.out.println("List<Events>daoimpl error"+e);
				return list;
		}
		
	}

	public Events getEventsById(int EventsId) {
		Events events=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			events=(Events)session.createQuery("from Events where EVENTSID = '"+EventsId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return events;
		}
		catch(Exception e){
			System.out.println("geteventsbyid error"+e);
			return events;
		}
		
	}

}
