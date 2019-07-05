package com.middleware.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.JobDAO;
import com.niit.backend.daoimpl.JobDAOImpl;
import com.niit.backend.model.Job;

@RestController
public class JobController {
    @GetMapping(value="/addJob")
	public String AddJob(HttpServletRequest req){
    	System.out.println("********************************************");
    	System.out.println("add job middleware controller");
    	System.out.println("********************************************");
    	
    	String jobdescription = req.getParameter("jobdescription");
    	String jobqualification = req.getParameter("jobqualification");
    	String str = req.getParameter("jobstatus");
    	char jobstatus = str.charAt(0);
    	String jobtitle = req.getParameter("jobtitle");
    	
    	Job job = new Job();
    	job.setJobDescription(jobdescription);
    	job.setJobQualification(jobqualification);
    	job.setJobStatus(jobstatus);
    	job.setJobTitle(jobtitle);
    	
    	try{
    		JobDAO jobdao = new JobDAOImpl();
    		jobdao.addJob(job);
    		System.out.println("jobdescription = "+jobdescription);
    		System.out.println("jobqualification = "+jobqualification);
    		System.out.println("jobstatus = "+jobstatus);
    		System.out.println("jobtitle = "+jobtitle);
    		return "data inserted in job table";
    	}
    	catch(Exception e){
    		System.out.println("addjobmiddleware error"+e.toString());
    		return null;	
    	}
	}
    @GetMapping(value="/allJob")
    public List<Job> getAllJob(HttpServletRequest req){
    	System.out.println("*****************************************");
    	System.out.println("all job middleware controller");
    	System.out.println("*****************************************");
    	try{
    		JobDAO jobdao = new JobDAOImpl();
    		List<Job>list=jobdao.getallJob();
    		Iterator item = list.iterator();
    		while(item.hasNext()){
    			Job job = (Job)item.next();
    			System.out.println("jobid = "+job.getJobId());
    			System.out.println("jobdateandtime = "+job.getJobDateandTime());
    			System.out.println("jobdescription = "+job.getJobDescription());
    			System.out.println("jobqualification = "+job.getJobQualification());
    			System.out.println("jobstatus = "+job.getJobStatus());
    			System.out.println("jobtitle = "+job.getJobTitle());
    			System.out.println("********************************************");
    		}
    		return list;
    	}
    	catch(Exception e){
    		System.out.println("alljobmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/jobById")
    public Job getJobById(@RequestParam("JobId")int JobId){
    	System.out.println("****************************************");
    	System.out.println("job by id middleware controller");
    	System.out.println("****************************************");
    	try{
    		JobDAO jobdao = new JobDAOImpl();
    		Job job = jobdao.getJobById(JobId);
    		if(job!=null){
    			System.out.println("jobid = "+job.getJobId());
    			System.out.println("jobdateandtime = "+job.getJobDateandTime());
    			System.out.println("jobdescription = "+job.getJobDescription());
    			System.out.println("jobqualification = "+job.getJobQualification());
    			System.out.println("jobstatus = "+job.getJobStatus());
    			System.out.println("jobtitle = "+job.getJobTitle());
    		}
    		return job;
    	}
    	catch(Exception e){
    		System.out.println("getjobbyidmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/deleteJob")
    public String DeleteJob(HttpServletRequest req){
    	System.out.println("***************************************");
    	System.out.println("delete job middleware controller");
    	System.out.println("***************************************");
    	String str = req.getParameter("jobid");
    	int jobid=Integer.parseInt(str);
    	try{
    		Job job = new Job();
    		job.setJobId(jobid);
    		JobDAO jobdao = new JobDAOImpl();
    		jobdao.deleteJob(job);
    		System.out.println("data deleted");
    		return "data deleted from table";
    	}
    	catch(Exception e){
    		System.out.println("deletejobmiddleware error"+e.toString());
    		return null;
    	}
    }
    @GetMapping(value="/updateJob")
    public String UpdateJob(HttpServletRequest req){
    	System.out.println("***************************************");
    	System.out.println("update job middleware controller");
    	System.out.println("***************************************");
    	String str = req.getParameter("jobid");
    	int jobid=Integer.parseInt(str);
    	try{
    		Job job = new Job();
    		job.setJobId(jobid);
    		job.setJobDescription("business knowledge of market with 8 year experience");
    		job.setJobQualification("BBA AND MBA");
    		job.setJobStatus('y');
    		job.setJobTitle("Marketing with sales");
    		JobDAO jobdao = new JobDAOImpl();
    		jobdao.updateJob(job);
    		System.out.println("data updated");
    		return"data updated from table";
    	}
    	catch(Exception e){
    		System.out.println("updatejobmiddleware error"+e.toString());
    		return null;
    	}
    }
}

