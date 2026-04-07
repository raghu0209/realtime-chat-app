package com.springwebsockets.service;

import org.springframework.stereotype.Service;

import com.springwebsockets.entity.WebSocketsUsersChat;
import com.springwebsockets.repository.WebSocketsUsersChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserChatService {

	private final WebSocketsUsersChatRepository webSocketsUsersChatRepository;

	public Long openChat(Long currentUserId, Long otherUserId) {
		
		System.out.println("Opening chat between User " + currentUserId + " and User " + otherUserId);

		// ✅ Normalize user order
		Long user1 = Math.min(currentUserId, otherUserId);
		Long user2 = Math.max(currentUserId, otherUserId);

		// ✅ Check if chat already exists (order-independent)
		WebSocketsUsersChat chat = webSocketsUsersChatRepository.findByCurrentUserIdAndOtherUserId(user1, user2);

		if (chat != null && chat.getChatId() != null) {
			System.out.println("Chat already exists with ID: " + chat.getChatId());
			return chat.getChatId();
		}

		// ✅ Create new chat
		WebSocketsUsersChat newChat = new WebSocketsUsersChat();
		newChat.setCurrentUserId(user1);
		newChat.setOtherUserId(user2);

		// ✅ Generate consistent chatId
		newChat.setChatId(generateChatId(user1, user2));
		
		System.out.println("Creating new chat with ID: " + newChat.getChatId());

		WebSocketsUsersChat saved = webSocketsUsersChatRepository.save(newChat);

		return saved.getChatId();
	}

	private Long generateChatId(Long user1, Long user2) {
		return Long.parseLong(user1 + "" + user2);
	}

}
