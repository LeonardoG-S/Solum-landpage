package com.example.api_email.controller;

import com.example.api_email.model.Email;
import com.example.api_email.service.EmailService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "https://solumlandpage.netlify.app/")
public class EmailController {

    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> enviar(@RequestBody Email email) {
        service.enviar(email);
        return ResponseEntity.ok("Enviado");
    }
}