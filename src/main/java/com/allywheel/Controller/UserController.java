package com.allywheel.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.allywheel.Model.UserModel;
import com.allywheel.Repository.UserRepository;

@RestController 
public class UserController {

	@Autowired
	private  UserRepository userRepository;
	
	@GetMapping("/home")
	
	public List<UserModel> getUser(){
	    return this.userRepository.findAll();
	}

	
	// save the  user detail in database
	
	@PostMapping("/register") 
	public ResponseEntity<?> userRegistration(@RequestBody UserModel customer){
		System.out.println(customer);
		this.userRepository.save(customer);
		return ResponseEntity.ok("data save successfully");
	}
	
	// get all the user 
//	 @GetMapping("/getUser")
//	 public List<UserModel> getUser(){
//		 return this.userRepository.findAll();
//	 }
//	 
	@GetMapping("/getData/{name}")
	public ResponseEntity<List<UserModel>> getUser(@PathVariable String name) {
	    List<UserModel> users = this.userRepository.findAllByName(name);
	    if(users.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(users);
	    }
	}
	

	
}
