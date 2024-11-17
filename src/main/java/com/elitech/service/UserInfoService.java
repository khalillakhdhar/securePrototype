package com.elitech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elitech.entity.User;
import com.elitech.repository.UserRepository;
@Service

public class UserInfoService implements UserDetailsService {
@Autowired
	private PasswordEncoder passwordEncoder;
private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userInfo=userRepository.findByEmail(username);
		return userInfo.map(UserInfo::new)
				.orElseThrow(()-> new UsernameNotFoundException("User not found with email "+username));
	}

}
