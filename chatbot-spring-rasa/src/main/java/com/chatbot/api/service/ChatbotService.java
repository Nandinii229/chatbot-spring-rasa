package com.chatbot.api.service;

import com.chatbot.api.model.ChatRequest;
import com.chatbot.api.model.ChatResponse;

public interface ChatbotService {
    ChatResponse processMessage(ChatRequest request);
}