package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Message;

public interface MessageDAO {
public boolean addMessage(Message message);
public boolean deleteMessage(Message message);
public boolean updateMessage(Message message);
public List<Message>getallMessage();
public Message getMessageById(int MessageId);
}
