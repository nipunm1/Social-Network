package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.User;

public interface UserDAO {
public boolean addUser(User user);
public boolean deleteUser(User user);
public boolean updateUser(User user);
public List<User>getallUser();
public User getUserByEmail(String UserEmail);
public List<User>getallOtherUser(String UserEmail);
public List<User>getUserByStatus(String UserStatus , String USEREMAIL);
public boolean changeUserStatus(String UserEmail,String UserStatus);
}
