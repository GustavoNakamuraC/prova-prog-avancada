package com.example.demo.service;

import com.example.demo.controller.dto.PessoaRequestDto;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;
    @Autowired
    private TrabalhoService trabalhoService;
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public Pessoa cadastrar(PessoaRequestDto pessoaRequestDto){
        Trabalho trabalho = trabalhoService.buscarPorId(pessoaRequestDto.getIdTrabalho());

        Pessoa pessoaSalva = new Pessoa(
                pessoaRequestDto.getNome(),
                pessoaRequestDto.getCpf(),
                trabalho);
        pessoaSalva = repository.save(pessoaSalva);

        return pessoaSalva;
    }

    public List<Pessoa> listar() {
        return repository.findAll();
    }

    public Pessoa buscarPorId(Long id){
        Optional<Pessoa> pessoaBuscada = repository.findById(id);

        if (pessoaBuscada.isEmpty()){
            throw new RuntimeException("Pessoa não existe.");
        }

        return pessoaBuscada.get();
    }

    public Pessoa atualizarPessoa(Long id, PessoaRequestDto pessoaRequestDto){
        Pessoa pessoaNova = buscarPorId(id);
        Trabalho trabalhoNovo = trabalhoService.buscarPorId(pessoaRequestDto.getIdTrabalho());

        pessoaNova.setNome(pessoaRequestDto.getNome());
        pessoaNova.setCpf(pessoaRequestDto.getCpf());
        pessoaNova.setTrabalho(trabalhoNovo);

        return repository.save(pessoaNova);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}