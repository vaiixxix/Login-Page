package com.example.investment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.investment.entity.User;

@Repository
public interface UserInterface extends JpaRepository<User, String> {
	
	@Query(value = "select * from user_tbl where username = :username", nativeQuery = true)
	Optional<User> findByUsername(String username);

//	@Query(value = "select * from user_tbl where username = :username AND password = :password", nativeQuery = true)
//	User login(User user);

	
}
