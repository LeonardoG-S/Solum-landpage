package com.example.api_email.model;

public class Email {
    private String nome;
    private String email;
    private String mensagem;

    public Email() {}

    public Email(String nome, String email, String mensagem){
        this.nome = nome;
        this.email = email;
        this.mensagem = mensagem;
    }

    //Getter e Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}