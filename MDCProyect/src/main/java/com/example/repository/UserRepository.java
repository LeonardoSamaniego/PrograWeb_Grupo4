package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
	public Users findByDni(String username);
	public Users findByEmail(String username);
	
	@Query(value="Select u FROM User u WHERE u.email =:email and u.password =:pass",nativeQuery =true)
	public Users findByEmailAndPassword(@Param("email") String email , @Param("pass") String pass);
	
	
}
