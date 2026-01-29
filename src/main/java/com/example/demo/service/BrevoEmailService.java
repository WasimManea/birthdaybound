package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class BrevoEmailService {

    @Value("${brevo.api-key}")
    private String apiKey;

    @Value("${brevo.url}")
    private String brevoUrl;

    @Value("${brevo.sender.email}")
    private String senderEmail;

    @Value("${brevo.sender.name}")
    private String senderName;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendHtmlEmail(String to, String subject, String htmlBody) {

        try {
            Map<String, Object> payload = new HashMap<>();

            payload.put("sender", Map.of(
                    "email", senderEmail,
                    "name", senderName
            ));

            payload.put("to", List.of(
                    Map.of("email", to)
            ));

            payload.put("subject", subject);
            payload.put("htmlContent", htmlBody);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api-key", apiKey);

            HttpEntity<String> entity = new HttpEntity<>(
                    objectMapper.writeValueAsString(payload),
                    headers
            );

            ResponseEntity<String> response =
                    restTemplate.postForEntity(brevoUrl, entity, String.class);

            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Brevo email failed: " + response.getBody());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error sending email via Brevo", e);
        }
    }
}
