package com.example.demo.controller.dto;

public class PessoaRequestDto {
    private String nome;
    private String cpf;
    private Long idTrabalho;

    public PessoaRequestDto(String nome, String cpf, Long idTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.idTrabalho = idTrabalho;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String  getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdTrabalho() {
        return idTrabalho;
    }
    public void setIdTrabalho(Long idTrabalho) {
        this.idTrabalho = idTrabalho;
    }
}
