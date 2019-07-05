package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Job;

public interface JobDAO {
public boolean addJob(Job job);
public boolean deleteJob(Job job);
public boolean updateJob(Job job);
public List<Job>getallJob();
public Job getJobById(int JobId);
}
