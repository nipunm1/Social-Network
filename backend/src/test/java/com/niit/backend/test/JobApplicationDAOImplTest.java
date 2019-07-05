package com.niit.backend.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.JobApplicationDAO;
import com.niit.backend.daoimpl.JobApplicationDAOImpl;
import com.niit.backend.model.JobApplication;

public class JobApplicationDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    @Ignore
	@Test
	public void addjobapplicationtest() {
		System.out.println("addjobapplicationtest begins");
		try{
			JobApplication jobapplication = new JobApplication();
			jobapplication.setJobApplicationRemarks("poor");
			jobapplication.setJobApplicationStatus("no");
			JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
			boolean b = jobapplicationdao.addJobApplication(jobapplication);
			System.out.println("data added");
			assertTrue(b);
		}
		catch(Exception e){
			System.out.println("addjobapplicationdaoimpltest error"+e);
		}
	}
    @Ignore
    @Test
    public void getalljobapplicationtest(){
    	System.out.println("getalljobapplicationtest begins");
    	boolean b=false;
    	JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    	try{
    		List<JobApplication>list=jobapplicationdao.getallJobApplication();
    		if(list!=null){
    			Iterator item = list.iterator();
    			while(item.hasNext()){
    				JobApplication jobapplication = (JobApplication)item.next();
    				System.out.println("jobapplicationid = "+jobapplication.getJobApplicationId());
    				System.out.println("jobapplicationdateandtime = "+jobapplication.getJobApplicationDate());
    				System.out.println("jobapplicationremarks = "+jobapplication.getJobApplicationRemarks());
    				System.out.println("jobapplicationstatus = "+jobapplication.getJobApplicationStatus());
    			}
    		}
    		b=true;
    	}
    	catch(Exception e){
    		System.out.println("getalljobapplicationtest error");
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void getjobapplicationbyidtest(){
    	System.out.println("getjobapplicationbyidtest begins");
    	boolean b=false;
    	JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    	try{
    		JobApplication jobapplication = jobapplicationdao.getJobApplicationById(61);
    		if(jobapplication!=null){
    			System.out.println("jobapplicationid = "+jobapplication.getJobApplicationId());
				System.out.println("jobapplicationdateandtime = "+jobapplication.getJobApplicationDate());
				System.out.println("jobapplicationremarks = "+jobapplication.getJobApplicationRemarks());
				System.out.println("jobapplicationstatus = "+jobapplication.getJobApplicationStatus());
    		}
    		b=true;
    	}
    	catch(Exception e){
    		b=false;
    	}
    	assertTrue(b);
    }
    @Ignore
    @Test
    public void deletejobapplicationtest(){
    	System.out.println("deletejobapplicationtest begins");
    	try{
    		JobApplication jobapplication = new JobApplication();
    		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    		jobapplication.setJobApplicationId(61);
    		boolean b = jobapplicationdao.deleteJobApplication(jobapplication);
    		System.out.println("data deleted");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("deletejobapplicationtest error"+e);
    	}
    }
    @Ignore
    @Test
    public void updatejobapplicationtest(){
    	System.out.println("updatejobapplicationtest begins");
    	try{
    		JobApplication jobapplication = new JobApplication();
    		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    		boolean b=jobapplicationdao.updateJobApplication(jobapplication);
    		System.out.println("data updated");
    		assertTrue(b);
    	}
    	catch(Exception e){
    		System.out.println("updatejobapplication error"+e);
    	}
    }

}
