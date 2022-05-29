package com.example.service;

import java.util.Arrays;
import java.util.List;

import com.example.utils.Constants;
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

	public String getEmailDomain(String email) {
		return email.substring(email.indexOf("@") + 1);
	}

	public boolean isValidEmail(String email) {
		return Arrays.asList(Constants.VALID_CUSTOMER_DOMAIN_EMAIL,
				Constants.VALID_ADMIN_DOMAIN_EMAIL).contains(getEmailDomain(email));
	}

	public User handleUserTypeByEmailDomain(User user) {
		if (user.getEmail() != null && isValidEmail(user.getEmail())) {
			switch (getEmailDomain(user.getEmail())) {
				case Constants.VALID_ADMIN_DOMAIN_EMAIL:
					user.setType(Constants.ADMIN_TYPE_ID);
					break;
				case Constants.VALID_CUSTOMER_DOMAIN_EMAIL:
					user.setType(Constants.CUSTOMER_TYPE_ID);
					break;
				default:
					break;
			}
		}
		return user;
	}
}
