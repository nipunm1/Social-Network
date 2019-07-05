package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.JobDAO;
import com.niit.backend.daoimpl.JobDAOImpl;
import com.niit.backend.model.Job;

public class JobDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
@Ignore
@Test
public void addjobtest() {
	System.out.println("addjobtest begins");
try{
	Job job = new Job();
	job.setJobDescription("C++ developer with knowlodge of busniss");
	job.setJobQualification("BCA + MBA or MCA + BBA");
	job.setJobStatus('y');
	job.setJobTitle("c++ developer with business");
	JobDAO jobdao = new JobDAOImpl();
	boolean b = jobdao.addJob(job);
	System.out.println("data added");
	assertTrue(b);
		}
catch(Exception e){
			System.out.println("addjobtest error"+e);
}
}
@Ignore
@Test
public void getalljobtest(){
	System.out.println("getalljobtest begins");
	boolean b=false;
	JobDAO jobdao = new JobDAOImpl();
	try{
		List<Job>list=jobdao.getallJob();
		if(list!=null){
			Iterator item = list.iterator();
			while(item.hasNext()){
				Job job =(Job)item.next();
				System.out.println("jobid = "+job.getJobId());
				System.out.println("jobdescription = "+job.getJobDescription());
				System.out.println("jobdate&time = "+job.getJobDateandTime());
				System.out.println("jobstatus = "+job.getJobStatus());
				System.out.println("jobqualification = "+job.getJobQualification());
				System.out.println("jobtitle = "+job.getJobTitle());
			}
			b=true;
		}
	}
	catch(Exception e){
		System.out.println("getalljobtest error"+e);
		b=false;
	}
	assertTrue(b);
}
@Ignore
@Test
public void getjobbyidtest(){
	System.out.println("getjobbyidtest begins");
	boolean b=false;
	JobDAO jobdao = new JobDAOImpl();
	try{
		b=true;
		Job job = jobdao.getJobById(60);
		if(job!=null){
			System.out.println("jobid = "+job.getJobId());
			System.out.println("jobdescription = "+job.getJobDescription());
			System.out.println("jobdate&time = "+job.getJobDateandTime());
			System.out.println("jobstatus = "+job.getJobStatus());
			System.out.println("jobqualification = "+job.getJobQualification());
			System.out.println("jobtitle = "+job.getJobTitle());
		}
	}
	catch(Exception e){
		System.out.println("getjobbyidtest error"+e);
		b=false;
	}
	assertTrue(b);
}
@Ignore
@Test
public void deletejobtest(){
	System.out.println("deletejobtest begins");
	try{
		Job job = new Job();
		JobDAO jobdao = new JobDAOImpl();
		job.setJobId(59);
		boolean b = jobdao.deleteJob(job);
		System.out.println("data deleted");
		assertTrue(b);
	}
	catch(Exception e){
		System.out.println("deletejobtest error"+e);
	}
}
@Ignore
@Test
public void updatejobtest(){
	System.out.println("updatejobtest begins");
	try{
		Job job = new Job();
		JobDAO jobdao = new JobDAOImpl();
		boolean b = jobdao.updateJob(job);
		System.out.println("data updated");
		assertTrue(b);
	}
	catch(Exception e){
		System.out.println("updatejobtest error");
	}
}
}
