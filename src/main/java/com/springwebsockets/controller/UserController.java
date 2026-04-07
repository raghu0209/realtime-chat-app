package com.springwebsockets.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springwebsockets.entity.WebSocketUsers;
import com.springwebsockets.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/{id}")
	public WebSocketUsers getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping
	public List<WebSocketUsers> getAllUsers() {
		return userService.getAllUsers();
	}

}
