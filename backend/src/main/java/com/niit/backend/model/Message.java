package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "S_Message")
@Component
public class Message {
@Id
@GeneratedValue
int MessageId;
private String MessageText;
private String MessageFrom;
public int getMessageId() {
	return MessageId;
}
public void setMessageId(int messageId) {
	MessageId = messageId;
}
public String getMessageText() {
	return MessageText;
}
public void setMessageText(String messageText) {
	MessageText = messageText;
}
public String getMessageFrom() {
	return MessageFrom;
}
public void setMessageFrom(String messageFrom) {
	MessageFrom = messageFrom;
}
}
