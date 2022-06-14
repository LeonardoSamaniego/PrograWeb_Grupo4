package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Users;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
	
	@Query(value="Select u FROM User u WHERE u.email =:email and u.password =:pass",nativeQuery =true)
	public Users findByEmailAndPassword(@Param("email") String email , @Param("pass") String pass);

	@Query(value="Select p FROM Users p WHERE p.type =:type")
	public List<Users> findByRole(@Param("type") int type);
}
