package com.example.demo.controller;

import com.example.demo.controller.dto.TrabalhoDto;
import com.example.demo.controller.dto.TrabalhoRequestDto;
import com.example.demo.mapper.TrabalhoMapper;
import com.example.demo.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @PostMapping
    public ResponseEntity<TrabalhoDto> cadastrar(@RequestBody TrabalhoRequestDto trabalhoDto){
        TrabalhoDto trabalhoSalvo = TrabalhoMapper.entityParaDto(service.cadastrar(trabalhoDto));

        return ResponseEntity.created(
                UriComponentsBuilder
                        .newInstance()
                        .path("/trabalhos/{id}")
                        .buildAndExpand(trabalhoSalvo.getId())
                        .toUri())
                .body(trabalhoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<TrabalhoDto>> listar(){
        List<TrabalhoDto> trabalhoDtoList = service.listar()
                .stream().map(TrabalhoMapper::entityParaDto).toList();

        return ResponseEntity.ok(trabalhoDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDto> buscarPorId(@PathVariable Long id){
        TrabalhoDto trabalhoBuscar = TrabalhoMapper.entityParaDto(service.buscarPorId(id));

        return ResponseEntity.ok(trabalhoBuscar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoDto> atualizarTrabalho(@PathVariable Long id, @RequestBody TrabalhoRequestDto trabalhoDto){
        TrabalhoDto trabalhoAtualizado = TrabalhoMapper.entityParaDto(service.atualizarTrabalho(id, trabalhoDto));

        return ResponseEntity.ok(trabalhoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}