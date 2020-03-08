package com.xworkz.user_app.resource;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.user_app.entity.UserEntity;
import com.xworkz.user_app.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	
	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/save")
	public ResponseEntity<UserEntity> saveData(@RequestBody UserEntity entity){
		
		log.info("data is {}",entity);
		UserEntity userEntity = iUserService.saveEntity(entity);
		return new ResponseEntity<>(userEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserById")
	public ResponseEntity<UserEntity> getById(@RequestParam Integer id){
		log.info("id is {}",id);

		UserEntity entity = iUserService.getUserById(id);
		return new ResponseEntity<>(entity,HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserEntity>> getAll(){
		log.info("qwertyuiop");
		List<UserEntity> getAll= iUserService.getAllUser();
		return new ResponseEntity<>(getAll,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<UserEntity> updateById(@PathVariable Integer id,@RequestBody UserEntity entity)
	{
		UserEntity user = iUserService.updateById(id,entity);
		log.info("Id is {} \n entity is {}",id,entity);
		return new ResponseEntity<>(user,HttpStatus.OK);
	} 	
	
	@PutMapping("/updateNameById/{id}")
	public ResponseEntity<UserEntity> updateById(@PathVariable Integer id,@RequestBody HashMap<String, String> map)
	{
//		UserEntity user = iUserService.updateById(id,entity);
		log.info("Id is {} \n entity is {}",id,map.get("name"));
		Integer updt = iUserService.updateNameById(id,map.get("name"));
		return new ResponseEntity<>(null,HttpStatus.OK);
	} 	
	
	@GetMapping("/getUserByName")
	public ResponseEntity<UserEntity> getByName(@RequestParam String name){
		log.info("username is {}",name);
		UserEntity user = iUserService.getUserByName(name);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
