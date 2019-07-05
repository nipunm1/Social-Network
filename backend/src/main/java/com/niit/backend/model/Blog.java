package com.niit.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "S_Blog")
@Component
public class Blog {
@Id
@GeneratedValue
int BlogId;
private String BlogName;
public int getBlogDislikes() {
	return BlogDislikes;
}
public void setBlogDislikes(int blogDislikes) {
	BlogDislikes = blogDislikes;
}
private String BlogComment;
private String BlogDate;
private int BlogLikes;
private int BlogDislikes;
private String BlogStatus;
public int getBlogId() {
	return BlogId;
}
public void setBlogId(int blogId) {
	BlogId = blogId;
}
public String getBlogName() {
	return BlogName;
}
public void setBlogName(String blogName) {
	BlogName = blogName;
}
public String getBlogComment() {
	return BlogComment;
}
public void setBlogComment(String blogComment) {
	BlogComment = blogComment;
}
public String getBlogDate() {
	return BlogDate;
}
public void setBlogDate(String blogDate) {
	BlogDate = blogDate;
}
public int getBlogLikes() {
	return BlogLikes;
}
public void setBlogLikes(int blogLikes) {
	BlogLikes = blogLikes;
}
public String getBlogStatus() {
	return BlogStatus;
}
public void setBlogStatus(String blogStatus) {
	BlogStatus = blogStatus;
}
//**********************************************************************************
String UserEmail;
int type;
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public String getUserEmail() {
	return UserEmail;
}
public void setUserEmail(String userEmail) {
	UserEmail = userEmail;
}
}