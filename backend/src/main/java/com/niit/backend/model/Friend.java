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
@Table(name = "S_Friend")
@Component
public class Friend {
@Id
@GeneratedValue
int FriendId;
private String FriendType;
private String FriendEmailId;

private String FriendImage;
private String FriendUserImage;
public String getFriendUserImage() {
	return FriendUserImage;
}
public void setFriendUserImage(String friendUserImage) {
	FriendUserImage = friendUserImage;
}
public String getFriendImage() {
	return FriendImage;
}
public void setFriendImage(String friendImage) {
	FriendImage = friendImage;
}
public int getFriendId() {
	return FriendId;
}
public void setFriendId(int friendId) {
	FriendId = friendId;
}
public String getFriendType() {
	return FriendType;
}
public void setFriendType(String friendType) {
	FriendType = friendType;
}
public String getFriendEmailId() {
	return FriendEmailId;
}
public void setFriendEmailId(String friendEmailId) {
	FriendEmailId = friendEmailId;
}
//****************************************************************************
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "UserEmail")
User UserEmail;

public User getUserEmail() {
	return UserEmail;
}
public void setUserEmail(User userEmail) {
	UserEmail = userEmail;
}


int Friends;
public int getFriends() {
	return Friends;
}
public void setFriends(int friends) {
	Friends = friends;
}

}