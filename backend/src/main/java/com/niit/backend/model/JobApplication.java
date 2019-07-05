package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="S_JobApplication")
@Component
public class JobApplication {
@Id
@GeneratedValue
int JobApplicationId;
public int getJobApplicationId() {
	return JobApplicationId;
}
public void setJobApplicationId(int jobApplicationId) {
	JobApplicationId = jobApplicationId;
}
public String getJobApplicationDate() {
	return JobApplicationDate;
}
public void setJobApplicationDate(String jobApplicationDate) {
	JobApplicationDate = jobApplicationDate;
}
public String getJobApplicationRemarks() {
	return JobApplicationRemarks;
}
public void setJobApplicationRemarks(String jobApplicationRemarks) {
	JobApplicationRemarks = jobApplicationRemarks;
}
public String getJobApplicationStatus() {
	return JobApplicationStatus;
}
public void setJobApplicationStatus(String jobApplicationStatus) {
	JobApplicationStatus = jobApplicationStatus;
}
private String JobApplicationDate;
private String JobApplicationRemarks;
private String JobApplicationStatus;
}
