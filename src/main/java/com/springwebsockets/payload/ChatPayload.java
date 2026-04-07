package com.springwebsockets.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatPayload {
	
	private Long chatId;
	private String chatMessage;
	private Long senderId;   // ✅ ADD THIS

}
