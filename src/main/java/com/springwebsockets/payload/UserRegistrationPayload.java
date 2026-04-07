package com.springwebsockets.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegistrationPayload {
	
	private String fname;
	private String lname;
	private String email;
	private String password;

}
