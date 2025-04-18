package com.example.demo.service;

import com.example.demo.controller.dto.TrabalhoRequestDto;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repository;

    public Trabalho cadastrar(TrabalhoRequestDto trabalhoRequestDto){
        Trabalho trabalho = new Trabalho(trabalhoRequestDto.getEndereco());
        return repository.save(trabalho);
    }

    public List<Trabalho> listar(){
        return repository.findAll();
    }

    public Trabalho buscarPorId(Long id){
        Optional<Trabalho> trabalhoBuscado = repository.findById(id);

        if (trabalhoBuscado.isEmpty()){
            throw new RuntimeException("Trabalho não encontrado");
        }

        return trabalhoBuscado.get();
    }

    public Trabalho atualizarTrabalho(Long id, TrabalhoRequestDto trabalhoRequestDto){
        Trabalho trabalhoNovo = buscarPorId(id);

        trabalhoNovo.setEndereco(trabalhoRequestDto.getEndereco());

        return repository.save(trabalhoNovo);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }


}