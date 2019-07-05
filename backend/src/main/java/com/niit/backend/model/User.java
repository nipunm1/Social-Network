package com.niit.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="S_User")
@Component
public class User {
@Id
String UserEmail;
private String UserPassword;
private String UserName;
private String UserAddress;
private String UserNumber;
private int UserEnabled;
public String getUserEmail() {
	return UserEmail;
}
public void setUserEmail(String userEmail) {
	UserEmail = userEmail;
}
public String getUserPassword() {
	return UserPassword;
}
public void setUserPassword(String userPassword) {
	UserPassword = userPassword;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getUserAddress() {
	return UserAddress;
}
public void setUserAddress(String userAddress) {
	UserAddress = userAddress;
}
public String getUserNumber() {
	return UserNumber;
}
public void setUserNumber(String userNumber) {
	UserNumber = userNumber;
}
public int getUserEnabled() {
	return UserEnabled;
}
public void setUserEnabled(int userEnabled) {
	UserEnabled = userEnabled;
}
public String getUserRole() {
	return UserRole;
}
public void setUserRole(String userRole) {
	UserRole = userRole;
}
public String getUserStatus() {
	return UserStatus;
}
public void setUserStatus(String userStatus) {
	UserStatus = userStatus;
}
private String UserRole;
private String UserStatus;
//*****************************************************************************
@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)  
@JoinColumn(name="UserEmail")  
@OrderColumn(name="type")  
private List<Blog> blog;
public List<Blog> getBlog() {
	return blog;
}
public void setBlog(List<Blog> blog) {
	this.blog = blog;
}
@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
@JoinColumn(name="UserEmail")
private List<UserMultimedia> usermultimedia;
public List<UserMultimedia> getUsermultimedia() {
	return usermultimedia;
}
public void setUsermultimedia(List<UserMultimedia> usermultimedia) {
	this.usermultimedia = usermultimedia;
}

@OneToMany(mappedBy="UserEmail",fetch=FetchType.EAGER)
@OrderColumn(name="Friends")
private List<Friend> friend;
}