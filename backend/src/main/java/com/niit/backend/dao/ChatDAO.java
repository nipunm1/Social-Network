package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Chat;

public interface ChatDAO {
public boolean addChat(Chat chat);
public boolean deleteChat(Chat chat);
public boolean updateChat(Chat chat);
public List<Chat>getallChat();
public Chat getChatById(int ChatId);
public List<Chat>getChatFromFriend(String ChatTo,String ChatFrom);
}
