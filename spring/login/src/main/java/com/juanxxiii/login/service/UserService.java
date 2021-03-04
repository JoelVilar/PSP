package com.juanxxiii.login.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanxxiii.login.entities.User;
import com.juanxxiii.login.repository.IUserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private IUserRepository userRepository;
	
	public Long isUserCorrect(User user) {
		return this.userRepository.userIsCorrect(user.getName(),user.getPassword());
	}
	
	public Optional<User> getUser(Long id) {
		return this.userRepository.findById(id);
	}
	
	public Optional<User> createUser(User user) {
		Optional<User> userOptional = Optional.empty();
		if(this.userRepository.getUserByName(user.getName())==Long.valueOf(0)) {
			return userOptional.of(this.userRepository.save(user));
		}else return userOptional;
	}
}
