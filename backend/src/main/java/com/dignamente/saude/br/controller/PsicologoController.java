package com.dignamente.saude.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dignamente.saude.br.dto.Psicologo.PsicologoCreateDTO;
import com.dignamente.saude.br.dto.Psicologo.PsicologoResponseDTO;
import com.dignamente.saude.br.service.PsicologoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/psicologos")
public class PsicologoController {


    @Autowired
    private PsicologoService psicologoService;


    @GetMapping("")
    public ResponseEntity<List<PsicologoResponseDTO>> findPsicologos() {
        return ResponseEntity.ok(psicologoService.findPsicologos());

    }

    @PostMapping("")
    public ResponseEntity<Void> createPsicologo(@RequestBody @Valid PsicologoCreateDTO psicologoDto) {
        psicologoService.createPsicologo(psicologoDto);
        return ResponseEntity.status(201).build();

    }

    
    
}
