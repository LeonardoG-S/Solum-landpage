package com.example.api_email.service;

import com.example.api_email.model.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    private final RestClient restClient = RestClient.create("https://api.resend.com");

    @Value("${resend.api-key}")
    private String apiKey;

    @Value("${email.destino}")
    private String destino;

    public void enviar(Email email) {
        Map<String, Object> corpo = Map.of(
            "from", "Solum <onboarding@resend.dev>",
            "to", List.of(destino),
            "reply_to", email.getEmail(),
            "subject", "Novo contato de " + email.getNome(),
            "text", "Nome: " + email.getNome() + "\n"
                  + "Email: " + email.getEmail() + "\n\n"
                  + email.getMensagem()
        );

        restClient.post()
            .uri("/emails")
            .header("Authorization", "Bearer " + apiKey)
            .contentType(MediaType.APPLICATION_JSON)
            .body(corpo)
            .retrieve()
            .toBodilessEntity();
    }
}