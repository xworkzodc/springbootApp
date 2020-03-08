package com.xworkz.user_app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xworkz.user_app.entity.UserEntity;


public interface UserRepository  extends JpaRepository<UserEntity, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE UserEntity ent SET ent.name = :name WHERE ent.id=:id")
	Integer updateNameById(@Param("id") Integer id,@Param("name") String name);

	UserEntity findByName(String name);

}
