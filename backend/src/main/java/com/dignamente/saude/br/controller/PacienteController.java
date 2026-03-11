package com.dignamente.saude.br.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dignamente.saude.br.dto.Paciente.PacienteCreateDTO;
import com.dignamente.saude.br.dto.Paciente.PacienteResponseDTO;
import com.dignamente.saude.br.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;



    @GetMapping("")
    public ResponseEntity<List<PacienteResponseDTO>> findPacientes() {
        return ResponseEntity.ok(pacienteService.findPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> findPacienteById(@PathVariable UUID id) {
        return ResponseEntity.ok(pacienteService.findPacienteByID(id));
    }

    @PostMapping("")
    public ResponseEntity<Void> createPaciente(@RequestBody  @Valid PacienteCreateDTO pacienteDTO) {
        pacienteService.createPaciente(pacienteDTO);
        return ResponseEntity.status(201).build();
    }


    
}
