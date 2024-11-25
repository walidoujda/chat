package com.example.chat.controller;

import com.example.chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    @MessageMapping("/sendMessage") // Reçoit les messages envoyés par les clients
    @SendTo("/topic/messages") // Diffuse les messages à tous les abonnés
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("Message reçu de " + message.getSender() + ": " + message.getContent());

        // Vous pouvez ajouter une logique ici (par ex., formatage ou validation)
        return message; // Retourne le message pour diffusion
    }
}
