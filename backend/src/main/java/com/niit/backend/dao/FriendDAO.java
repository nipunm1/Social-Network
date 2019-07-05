package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Friend;
import com.niit.backend.model.User;

public interface FriendDAO {
public boolean addFriend(Friend friend);
public boolean deleteFriend(Friend friend);
public boolean deleteFriendByUserEmail(String FriendEmailId,String UserEmail);
public boolean updateFriend(Friend friend);
public List<Friend>getallFriend();
public Friend getFriendById(int FriendId);
public Friend getFriendByUserEmail(String UserEmail);
public Friend deleteFriendByFriendEmailId(String FriendEmailId,String UserEmail);
public List<Friend> getFriendListByUserEmail(String UserEmail,String FriendEmailId);
public List<Friend> getFriendListByFriendEmailId(String FriendEmailId,String UserEmail);
public List<Friend> FriendRequestSendToUser(String FriendEmailId,String UserEmail);
public List<Friend> RecieveNonConfirmRequest(String FriendEmailId,String FriendType);
public List<Friend> friendListConfirm(String FriendType);
public List<Friend> confirmFriendList(String UserEmail,String FriendEmailId,String FriendType);
public List<Friend> nonconfirmFriendList(String UserEmail,String FriendType);
public boolean convertNonconfirmToConfirm(int FriendId,String FriendType);
}
