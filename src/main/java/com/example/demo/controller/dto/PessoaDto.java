package com.example.demo.controller.dto;

public class PessoaDto {
    private Long id;
    private String nome;
    private String cpf;
    private TrabalhoDto trabalho;

    public PessoaDto(Long id, String nome, String cpf, TrabalhoDto trabalho) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.trabalho = trabalho;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TrabalhoDto getTrabalho() {
        return trabalho;
    }
    public void setTrabalho(TrabalhoDto trabalho) {
        this.trabalho = trabalho;
    }
}