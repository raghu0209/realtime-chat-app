package com.springwebsockets.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springwebsockets.entity.WebSocketMessage;
import com.springwebsockets.payload.ChatPayload;
import com.springwebsockets.repository.WebSocketMessageRepository;
import com.springwebsockets.service.UserChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class UserChatController {
	
	private final SimpMessagingTemplate messagingTemplate;
	private final UserChatService userChatService;
	private final WebSocketMessageRepository webSocketMessageRepository;
	
	@GetMapping("/open/{currentUserId}/{otherUserId}")
	public Long openChat(@PathVariable Long currentUserId, @PathVariable Long otherUserId) {
		return userChatService.openChat(currentUserId, otherUserId);
	}
	
	@MessageMapping("/send")
	public String sendMessage(ChatPayload chat) {
		WebSocketMessage message = new WebSocketMessage();
		message.setChatId(chat.getChatId());
		message.setSenderId(chat.getSenderId());
		message.setChatMessage(chat.getChatMessage());
		WebSocketMessage savedMessage = webSocketMessageRepository.save(message);
		
		String destination = "/topic/private/chat/" + chat.getChatId();
		messagingTemplate.convertAndSend(destination, chat);
		return "Message sent to chat ID: " + chat.getChatId();
	}
	
	@GetMapping("/history/{chatId}")
	public List<WebSocketMessage> getChatHistory(@PathVariable Long chatId) {
	    return webSocketMessageRepository.findByChatIdOrderByTimestampAsc(chatId);
	}

}
