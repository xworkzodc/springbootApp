package com.xworkz.user_app.service;

import java.util.List;

import com.xworkz.user_app.entity.UserEntity;

public interface IUserService {

	UserEntity saveEntity(UserEntity entity);

	UserEntity getUserById(Integer id);

	List<UserEntity> getAllUser();

	UserEntity updateById(Integer id, UserEntity entity);

	Integer updateNameById(Integer id, String string);

	UserEntity getUserByName(String name);

}
