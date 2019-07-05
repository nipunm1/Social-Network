package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.UserMultimedia;

public interface UserMultimediaDAO{
public boolean addUserMultimedia(UserMultimedia usermultimedia);
public boolean deleteUserMultimedia(UserMultimedia usermultimedia);
public boolean updateUserMultimedia(UserMultimedia usermultimedia);
public List<UserMultimedia>getallUserMultimedia();
public UserMultimedia getUserMultimediaById(int UserMultimediaId);
public List<UserMultimedia>getUserMultimediaByUserEmail(String UserEmail);
public List<UserMultimedia>getOtherUserMultimediaByUserEmail(String UserEmail);
public UserMultimedia addUserMultimediaLikes(int UserMultimediaId);
public UserMultimedia addUserMultimediaDislikes(int UserMultimediaId);
}
