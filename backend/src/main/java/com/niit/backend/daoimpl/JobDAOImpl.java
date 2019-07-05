package com.niit.backend.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.JobDAO;
import com.niit.backend.model.Job;

public class JobDAOImpl implements JobDAO{

	public boolean addJob(Job job) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			job.setJobDateandTime(df.format(date));
			session.save(job);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addjobdaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean deleteJob(Job job) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(job);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deletejobdaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean updateJob(Job job) {
		JobDAO jobdao = new JobDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			//job=jobdao.getJobById(60);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			job.setJobDateandTime(df.format(date));
			//job.setJobDescription("java developer with knowledge of web application");
			//job.setJobQualification("BCA AND MCA");
			//job.setJobStatus('y');
			//job.setJobTitle("JAVA");
			session.update(job);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updatejobdaoimpl error"+e);
			return false;	
		}
		
	}

	public List<Job> getallJob() {
		List<Job>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from Job").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("List<Job>daoimpl error"+e);
			return list;	
		}
		
	}

	public Job getJobById(int JobId) {
		Job job =null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			job=(Job)session.createQuery("from Job where JOBID = '"+JobId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return job;
		}
		catch(Exception e){
			System.out.println("getjobbyiddaoimpl error"+e);
			return job;	
		}
		
	}

}
