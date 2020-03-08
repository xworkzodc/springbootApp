package com.xworkz.user_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.user_app.entity.UserEntity;
import com.xworkz.user_app.repository.UserRepository;
import com.xworkz.user_app.util.EmailUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailUtil emailUtil;
	 
	@Override
	public UserEntity saveEntity(UserEntity entity) {
		try {
			entity = userRepository.save(entity);
			emailUtil.sendSimpleMessage(entity.getEmail(), "Just for Test", "qwertyuiopasdfghjklzxcvbnm");
		}catch (Exception e) {
			log.error("exception is {} and Message is {}",e,e.getMessage());
			return null;
		}
		return entity;
	}

	@Override
	public UserEntity getUserById(Integer id) {
		Optional<UserEntity> optUser = userRepository.findById(id);
		if(optUser.isPresent())
			return optUser.get();
		return null;
	}

	@Override
	public List<UserEntity> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity updateById(Integer id, UserEntity entity) {
		UserEntity userEntity = userRepository.getOne(id);
		if(userEntity!=null) 
		{
			if(entity.getEmail()!=null)
				userEntity.setEmail(entity.getEmail());
			if(entity.getName()!=null)
				userEntity.setName(entity.getName());
			return userRepository.save(userEntity);
		}
		return null;
	}

	@Override
	public Integer updateNameById(Integer id, String name) {
		return userRepository.updateNameById(id,name);
	}

	@Override
	public UserEntity getUserByName(String name) {
		return userRepository.findByName(name);
	}

	
}
