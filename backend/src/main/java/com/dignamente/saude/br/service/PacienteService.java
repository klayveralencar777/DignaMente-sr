package com.dignamente.saude.br.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dignamente.saude.br.dto.Paciente.PacienteCreateDTO;
import com.dignamente.saude.br.dto.Paciente.PacienteResponseDTO;
import com.dignamente.saude.br.entities.Paciente;
import com.dignamente.saude.br.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PasswordEncoder passwordEncoder;

    public PacienteService(PacienteRepository pacienteRepository, PasswordEncoder passwordEncoder) {
        this.pacienteRepository = pacienteRepository;
        this.passwordEncoder = passwordEncoder;
    }
    

    public List<PacienteResponseDTO> findPacientes() {
        return pacienteRepository.findAll().stream().map(this::toDto).toList();
        
    }

    public PacienteResponseDTO findPacienteByID(UUID id) {
        Paciente paciente = pacienteRepository.findById(id).
        orElseThrow(() -> new RuntimeException("Paciente não econtrado com o id: " + id));
        return toDto(paciente);
                             
        
    }

    public void createPaciente(PacienteCreateDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setEmail(dto.getEmail());   
        String senhaCriptografada = passwordEncoder.encode(dto.getSenhaHash());

        paciente.setSenhaHash(senhaCriptografada);
        paciente.setCpf(dto.getCpf());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setAtivo(dto.getAtivo());
        paciente.setTelefone(dto.getTelefone());

        pacienteRepository.saveAndFlush(paciente);
        
 
            
    }

    private PacienteResponseDTO toDto(Paciente paciente) {
        return new PacienteResponseDTO(
            paciente.getId(),
            paciente.getNome(),
            paciente.getEmail(),
            paciente.getDataNascimento(),
            paciente.getTelefone(),
            paciente.getCpf(),
            paciente.isAtivo()
        
        );
    }
    
}
