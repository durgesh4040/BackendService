package com.allywheel.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.allywheel.Model.UserModel;
import com.allywheel.Repository.UserRepository;

@Service
public class CustomUserDetail implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel user=this.userRepository.findByEmail(username)
				.orElseThrow(()->new RuntimeException("User Not found"));
		return user;
	}

}
