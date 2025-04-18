package com.example.demo.mapper;

import com.example.demo.controller.dto.PessoaDto;
import com.example.demo.model.Pessoa;

public class PessoaMapper {

    public static PessoaDto entityParaDto (Pessoa pessoa){
        return new PessoaDto(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                TrabalhoMapper.entityParaDto(pessoa.getTrabalho())
        );
    }

}
