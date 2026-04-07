package com.springwebsockets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springwebsockets.entity.WebSocketMessage;

public interface WebSocketMessageRepository extends JpaRepository<WebSocketMessage, Long> {
    List<WebSocketMessage> findByChatIdOrderByTimestampAsc(Long chatId);
}
