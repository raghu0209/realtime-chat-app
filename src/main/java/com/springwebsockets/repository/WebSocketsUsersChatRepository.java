package com.springwebsockets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springwebsockets.entity.WebSocketsUsersChat;

public interface WebSocketsUsersChatRepository extends JpaRepository<WebSocketsUsersChat, Long> {

	WebSocketsUsersChat findByCurrentUserIdAndOtherUserId(Long currentUserId, Long otherUserId);

}
