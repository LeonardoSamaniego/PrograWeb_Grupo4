package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.User;

public interface UserRepository  extends JpaRepository<User, Long> {
	@Query("Select u FROM User u WHERE u.email =:email and u.password =:pass")
	public User findByEmailAndPassword(@Param("email") String email , @Param("pass") String pass);
}
