package com.niit.backend.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.backend.config.dbconfig;
import com.niit.backend.dao.JobApplicationDAO;
import com.niit.backend.model.JobApplication;

public class JobApplicationDAOImpl implements JobApplicationDAO {

	public boolean addJobApplication(JobApplication jobapplication) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			jobapplication.setJobApplicationDate(df.format(date));
			session.save(jobapplication);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("addjobapplicationdaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean deleteJobApplication(JobApplication jobapplication) {
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(jobapplication);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("deletejobapplicationdaoimpl error"+e);
			return false;	
		}
		
	}

	public boolean updateJobApplication(JobApplication jobapplication) {
		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
		    //jobapplication = jobapplicationdao.getJobApplicationById(62);
			jobapplication.setJobApplicationDate(df.format(date));
			//jobapplication.setJobApplicationRemarks("nice");
			//jobapplication.setJobApplicationStatus("yes");
			session.update(jobapplication);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e){
			System.out.println("updatejobapplicationdaoimpl error"+e);
			return false;	
		}
		
	}

	public List<JobApplication> getallJobApplication() {
		List<JobApplication>list=null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			list=(List)session.createQuery("from JobApplication").list();
			tx.commit();
			session.flush();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("List<JobApplication>daoimpl error"+e);
			return list;	
		}
		
	}

	public JobApplication getJobApplicationById(int JobApplicationId) {
		JobApplication jobapplication = null;
		try{
			SessionFactory sessionfactory = dbconfig.getSessionFactory(dbconfig.getDataSource());
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			jobapplication=(JobApplication)session.createQuery("from JobApplication where JOBAPPLICATIONID = '"+JobApplicationId+"'").uniqueResult();
			tx.commit();
			session.flush();
			session.close();
			return jobapplication;
		}
		catch(Exception e){
			System.out.println("getjobapplicationbyid error"+e);
			return jobapplication;
		}
		
	}

}
