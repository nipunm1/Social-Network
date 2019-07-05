package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.JobApplication;

public interface JobApplicationDAO {
public boolean addJobApplication(JobApplication jobapplication);
public boolean deleteJobApplication(JobApplication jobapplication);
public boolean updateJobApplication(JobApplication jobapplication);
public List<JobApplication>getallJobApplication();
public JobApplication getJobApplicationById(int JobApplicationId);
}
