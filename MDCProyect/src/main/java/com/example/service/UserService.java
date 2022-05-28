<<<<<<< Updated upstream
package com.example.service;

import java.util.List;

import com.example.entities.Users;

public interface UserService {

	Users insert(Users user);

	Users update(Users user);

	Users getById(Long id);

	void delete(Long id);

	List<Users> findAll();

	Users findByUsername(String username);

}
=======
package com.example.service;

import java.util.List;

import com.example.entities.Users;

public interface UserService {

	Users insert(Users user);

	Users update(Users user);

	Users getById(Long id);

	void delete(Long id);

	List<Users> findAll();

	Users findByUsername(String username);

}
>>>>>>> Stashed changes
