package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User insert(User user) {
		this.userRepository.save(user);
		return user;
	}

	public User update(User user) {
		this.userRepository.save(user);
		return user;
	}
	
	public User getById(Long id) {
		User user = this.userRepository.findById(id).get();
		return user;
	}

	public void delete(Long id){
		this.userRepository.deleteById(id);
	}

	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
	public User getByEmailandPass(User user) {
		return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
	}


}
