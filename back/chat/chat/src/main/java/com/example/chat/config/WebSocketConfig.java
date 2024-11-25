package com.example.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Broker pour diffuser les messages
        config.setApplicationDestinationPrefixes("/app"); // Préfixe des messages entrants
    }

    @Override
    public void registerStompEndpoints(
            org.springframework.web.socket.config.annotation.StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-websocket").setAllowedOrigins("http://localhost:4200").withSockJS(); // Endpoint
                                                                                                         // WebSocket
    }
}
