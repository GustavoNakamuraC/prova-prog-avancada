package com.example.demo.controller;

import com.example.demo.controller.dto.PessoaDto;
import com.example.demo.controller.dto.PessoaRequestDto;
import com.example.demo.mapper.PessoaMapper;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaDto> cadastrar(@RequestBody PessoaRequestDto pessoaDto){
        PessoaDto pessoaSalva = PessoaMapper.entityParaDto(service.cadastrar(pessoaDto));

        return ResponseEntity.created(
                UriComponentsBuilder
                        .newInstance()
                        .path("/pessoas/{id}")
                        .buildAndExpand(pessoaSalva.getId())
                        .toUri())
                .body(pessoaSalva);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> listar(){
        List<PessoaDto> pessoaDtoList = service.listar()
                .stream().map(PessoaMapper::entityParaDto).toList();

        return ResponseEntity.ok(pessoaDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> buscarPorId(@PathVariable Long id){
        PessoaDto pessoaBuscar = PessoaMapper.entityParaDto(service.buscarPorId(id));

        return ResponseEntity.ok(pessoaBuscar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaRequestDto pessoaDto){
        PessoaDto pessoaAtualizada = PessoaMapper.entityParaDto(service.atualizarPessoa(id, pessoaDto));

        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}