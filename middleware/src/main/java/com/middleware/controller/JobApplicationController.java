package com.middleware.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.JobApplicationDAO;
import com.niit.backend.daoimpl.JobApplicationDAOImpl;
import com.niit.backend.model.JobApplication;

@RestController
public class JobApplicationController {
    @GetMapping(value="/addJobApplication")
	public String AddJobApplication(HttpServletRequest req){
    	System.out.println("****************************************");
    	System.out.println("add jobapplication middleware controller");
    	System.out.println("****************************************");
    	
    	String jobapplicationremarks=req.getParameter("jobapplicationremarks");
    	String jobapplicationstatus=req.getParameter("jobapplicationstatus");
    	
    	JobApplication jobapplication = new JobApplication();
    	jobapplication.setJobApplicationRemarks(jobapplicationremarks);
    	jobapplication.setJobApplicationStatus(jobapplicationstatus);
    	
    	try{
    		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    		jobapplicationdao.addJobApplication(jobapplication);
    		System.out.println("jobapplicationremarks = "+jobapplicationremarks);
    		System.out.println("jobapplicationstatus = "+jobapplicationstatus);
    		return "data inserted in jobapplication table";
    	}
    	catch(Exception e){
    		System.out.println("addjobapplicationmiddleware error"+e.toString());
    		return null;	
    	}
	}
    @GetMapping(value="/allJobApplication")
    public List<JobApplication>getAllJobApplication(HttpServletRequest req){
    	System.out.println("****************************************************");
    	System.out.println("all jobapplication middleware controller");
    	System.out.println("****************************************************");
    	try{
    		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    		List<JobApplication>list=jobapplicationdao.getallJobApplication();
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			JobApplication jobapplication = (JobApplication)item.next();
    			System.out.println("jobapplicationid = "+jobapplication.getJobApplicationId());
    			System.out.println("jobapplicationdate = "+jobapplication.getJobApplicationDate());
    			System.out.println("jobapplicationremakrs = "+jobapplication.getJobApplicationRemarks());
    			System.out.println("jobapplicationstatus = "+jobapplication.getJobApplicationStatus());
    			System.out.println("*******************************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("getalljobapplicationmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/jobapplicationById")
    public JobApplication getJobApplicationById(@RequestParam("JobApplicationId")int JobApplicationId){
    	System.out.println("************************************************");
    	System.out.println("jobapplication by id middleware controller");
    	System.out.println("************************************************");
    	try{
    		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    		JobApplication jobapplication = jobapplicationdao.getJobApplicationById(JobApplicationId);
    		if(jobapplication!=null){
    			System.out.println("jobapplicationid = "+jobapplication.getJobApplicationId());
    			System.out.println("jobapplicationdate = "+jobapplication.getJobApplicationDate());
    			System.out.println("jobapplicationremakrs = "+jobapplication.getJobApplicationRemarks());
    			System.out.println("jobapplicationstatus = "+jobapplication.getJobApplicationStatus());
    		}
    		return jobapplication;
    	}
    	catch(Exception e){
    		System.out.println("getjobapplicationbyidmiddleware error"+e.toString());
    		return null;	
    	}
    }
    @GetMapping(value="/deleteJobApplication")
    public String DeleteJobApplication(HttpServletRequest req){
    	System.out.println("*******************************************");
    	System.out.println("delete jobapplication middleware controller");
    	System.out.println("*******************************************");
    	String str = req.getParameter("jobapplicationid");
    	int jobapplicationid = Integer.parseInt(str);
    	try{
    		JobApplication jobapplication = new JobApplication();
    		jobapplication.setJobApplicationId(jobapplicationid);
    		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    		jobapplicationdao.deleteJobApplication(jobapplication);
    		System.out.println("data deleted");
    		return "data deleted from table";
    	}
    	catch(Exception e){
    		System.out.println("deletejobapplicationmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/updateJobApplication")
    public String UpdateJobApplication(HttpServletRequest req){
    	System.out.println("*****************************************");
    	System.out.println("update jobapplication middleware controller");
    	System.out.println("*****************************************");
    	String str = req.getParameter("jobapplicationid");
    	int jobapplicationid = Integer.parseInt(str);
    	try{
    		JobApplication jobapplication = new JobApplication();
    		jobapplication.setJobApplicationId(jobapplicationid);
    		jobapplication.setJobApplicationRemarks("poor");
    		jobapplication.setJobApplicationStatus("no");
    		JobApplicationDAO jobapplicationdao = new JobApplicationDAOImpl();
    		jobapplicationdao.updateJobApplication(jobapplication);
    		System.out.println("data updated");
    		return "data updated from table";
    	}
    	catch(Exception e){
    		System.out.println("updatejobapplicationmiddleware error"+e.toString());
    		return null;
    	}
    }
}
