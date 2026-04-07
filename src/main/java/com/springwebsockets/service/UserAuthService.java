package com.springwebsockets.service;

import org.springframework.stereotype.Service;

import com.springwebsockets.entity.WebSocketUsers;
import com.springwebsockets.payload.UserLoginPayload;
import com.springwebsockets.payload.UserRegistrationPayload;
import com.springwebsockets.repository.UserAuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthService {
	
	private final UserAuthRepository userAuthRepository;
	
	public String registerUser(UserRegistrationPayload request) {
		WebSocketUsers user = new WebSocketUsers();
		user.setFname(request.getFname());
		user.setLname(request.getLname());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		userAuthRepository.save(user);
		
		return "user registered successfully";
	}

	public WebSocketUsers loginUser(UserLoginPayload request) {
		WebSocketUsers user = userAuthRepository.findByEmail(request.getEmail());
		if(user == null) {
			return null;
		}
		return user;
	}

}
