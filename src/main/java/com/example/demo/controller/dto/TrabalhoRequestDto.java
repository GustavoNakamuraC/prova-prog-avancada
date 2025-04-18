package com.example.demo.controller.dto;

public class TrabalhoRequestDto {
    private String endereco;

    public TrabalhoRequestDto(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
