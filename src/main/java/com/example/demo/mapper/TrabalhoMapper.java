package com.example.demo.mapper;

import com.example.demo.controller.dto.TrabalhoDto;
import com.example.demo.model.Trabalho;

public class TrabalhoMapper {
    public static TrabalhoDto entityParaDto (Trabalho trabalho){
        return new TrabalhoDto(
                trabalho.getId(),
                trabalho.getEndereco()
        );
    }
}
