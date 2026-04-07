package com.springwebsockets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springwebsockets.entity.WebSocketUsers;

public interface UserAuthRepository extends JpaRepository<WebSocketUsers, Long>{

	WebSocketUsers findByEmail(String email);
	
}
