<<<<<<< Updated upstream
<<<<<<< Updated upstream
package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
}
=======
package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
}
>>>>>>> Stashed changes
=======
package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
}
>>>>>>> Stashed changes
