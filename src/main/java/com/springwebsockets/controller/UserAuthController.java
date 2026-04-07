package com.springwebsockets.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springwebsockets.entity.WebSocketUsers;
import com.springwebsockets.payload.UserLoginPayload;
import com.springwebsockets.payload.UserRegistrationPayload;
import com.springwebsockets.service.UserAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthController {
	
	private final UserAuthService userAuthService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserRegistrationPayload request) {
		return userAuthService.registerUser(request);
	}
	
	@PostMapping("/login")
	public WebSocketUsers loginUser(@RequestBody UserLoginPayload request) {
		return userAuthService.loginUser(request);
	}

}
