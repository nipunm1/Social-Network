package com.niit.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="S_UserMultimedia")
@Component
public class UserMultimedia {
@Id
@GeneratedValue
int UserMultimediaId;
public int getUserMultimediaId() {
	return UserMultimediaId;
}
public void setUserMultimediaId(int userMultimediaId) {
	UserMultimediaId = userMultimediaId;
}
public String getUserMultimediaAudio() {
	return UserMultimediaAudio;
}
public void setUserMultimediaAudio(String userMultimediaAudio) {
	UserMultimediaAudio = userMultimediaAudio;
}
public String getUserMultimediaVideo() {
	return UserMultimediaVideo;
}
public void setUserMultimediaVideo(String userMultimediaVideo) {
	UserMultimediaVideo = userMultimediaVideo;
}
public String getUserMultimediaImage() {
	return UserMultimediaImage;
}
public void setUserMultimediaImage(String userMultimediaImage) {
	UserMultimediaImage = userMultimediaImage;
}
public String getUserMultimediaTran() {
	return UserMultimediaTran;
}
public void setUserMultimediaTran(String userMultimediaTran) {
	UserMultimediaTran = userMultimediaTran;
}
private int UserMultimediaLikes;
private int UserMultimeidaDislikes;
public int getUserMultimediaLikes() {
	return UserMultimediaLikes;
}
public void setUserMultimediaLikes(int userMultimediaLikes) {
	UserMultimediaLikes = userMultimediaLikes;
}
public int getUserMultimeidaDislikes() {
	return UserMultimeidaDislikes;
}
public void setUserMultimeidaDislikes(int userMultimeidaDislikes) {
	UserMultimeidaDislikes = userMultimeidaDislikes;
}
private String UserMultimediaAudio;
private String UserMultimediaVideo;
private String UserMultimediaImage;
private String UserMultimediaTran;
//***************************************************************************
String UserEmail;
public String getUserEmail() {
	return UserEmail;
}
public void setUserEmail(String userEmail) {
	UserEmail = userEmail;
}
}