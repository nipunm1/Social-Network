package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "S_Chat")
@Component
public class Chat {
@Id
@GeneratedValue
int ChatId;
private String ChatMessage;
private String ChatDate;
public int getChatId() {
	return ChatId;
}
public void setChatId(int chatId) {
	ChatId = chatId;
}
public String getChatMessage() {
	return ChatMessage;
}
public void setChatMessage(String chatMessage) {
	ChatMessage = chatMessage;
}
public String getChatDate() {
	return ChatDate;
}
public void setChatDate(String chatDate) {
	ChatDate = chatDate;
}
public String ChatTo;
public String ChatFrom;
public String getChatTo() {
	return ChatTo;
}
public void setChatTo(String chatTo) {
	ChatTo = chatTo;
}
public String getChatFrom() {
	return ChatFrom;
}
public void setChatFrom(String chatFrom) {
	ChatFrom = chatFrom;
}
//*****************************************************************
}