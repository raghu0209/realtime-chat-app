package com.springwebsockets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springwebsockets.entity.WebSocketUsers;
import com.springwebsockets.repository.UserAuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserAuthRepository userAuthRepository;
	
	public WebSocketUsers getUserById(Long userId) {
		return userAuthRepository.findById(userId).orElse(null);
	}
	
	public List<WebSocketUsers> getAllUsers() {
		return userAuthRepository.findAll();
	}

}
