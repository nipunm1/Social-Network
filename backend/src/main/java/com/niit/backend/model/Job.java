package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="S_Job")
@Component
public class Job {
@Id
@GeneratedValue
int JobId;
private String JobTitle;
private String JobDescription;
private String JobDateandTime;
private String JobQualification;
private char JobStatus;
public int getJobId() {
	return JobId;
}
public void setJobId(int jobId) {
	JobId = jobId;
}
public String getJobTitle() {
	return JobTitle;
}
public void setJobTitle(String jobTitle) {
	JobTitle = jobTitle;
}
public String getJobDescription() {
	return JobDescription;
}
public void setJobDescription(String jobDescription) {
	JobDescription = jobDescription;
}
public String getJobDateandTime() {
	return JobDateandTime;
}
public void setJobDateandTime(String jobDateandTime) {
	JobDateandTime = jobDateandTime;
}
public String getJobQualification() {
	return JobQualification;
}
public void setJobQualification(String jobQualification) {
	JobQualification = jobQualification;
}
public char getJobStatus() {
	return JobStatus;
}
public void setJobStatus(char jobStatus) {
	JobStatus = jobStatus;
}
}
