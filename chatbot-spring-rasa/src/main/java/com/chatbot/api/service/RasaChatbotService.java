package com.chatbot.api.service;

import com.chatbot.api.model.ChatRequest;
import com.chatbot.api.model.ChatResponse;
import com.chatbot.api.model.RasaRequest;
import com.chatbot.api.model.RasaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RasaChatbotService implements ChatbotService {

    @Value("${rasa.url}")
    private String rasaUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ChatResponse processMessage(ChatRequest request) {
        try {
            RasaRequest rasaRequest = new RasaRequest(request.getMessage(), request.getUserId());
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<RasaRequest> entity = new HttpEntity<>(rasaRequest, headers);
            
            String rasaEndpoint = rasaUrl + "/webhooks/rest/webhook";
            System.out.println("Sending request to Rasa: " + rasaEndpoint);
            System.out.println("Request body: " + rasaRequest);
            
            ResponseEntity<RasaResponse[]> response = restTemplate.postForEntity(
                    rasaEndpoint,
                    entity,
                    RasaResponse[].class
            );
            
            RasaResponse[] responses = response.getBody();
            if (responses != null && responses.length > 0) {
                String responseText = responses[0].getText();
                if (responseText != null && !responseText.isEmpty()) {
                    return new ChatResponse(responseText, request.getUserId(), true);
                }
            }
            
            return new ChatResponse("Sorry, I didn't understand that.", request.getUserId(), false);
            
        } catch (Exception e) {
            System.err.println("Error communicating with Rasa: " + e.getMessage());
            e.printStackTrace();
            return new ChatResponse(
                    "I'm currently unable to process your request. Error: " + e.getMessage(),
                    request.getUserId(),
                    false
            );
        }
    }
}