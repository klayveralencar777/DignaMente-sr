package com.dignamente.saude.br.service;

import java.util.List;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dignamente.saude.br.dto.Psicologo.PsicologoCreateDTO;
import com.dignamente.saude.br.dto.Psicologo.PsicologoResponseDTO;
import com.dignamente.saude.br.entities.Psicologo;
import com.dignamente.saude.br.repository.PsicologoRepository;

@Service
public class PsicologoService {

    private final PsicologoRepository psicologoRepository;
    private final PasswordEncoder passwordEncoder;

    public PsicologoService(PsicologoRepository psicologoRepository, PasswordEncoder passwordEncoder) {
        this.psicologoRepository = psicologoRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<PsicologoResponseDTO> findPsicologos() {
        return psicologoRepository.findAll().stream().map(this::toDto).toList();

    }

    public void createPsicologo(PsicologoCreateDTO psicologoDto) {
        Psicologo psicologo = new Psicologo();
        psicologo.setNome(psicologoDto.getNome());
        psicologo.setCpf(psicologoDto.getCpf());
        psicologo.setEmail(psicologoDto.getEmail());
        psicologo.setEspecialidade(psicologoDto.getEspecialidade());
        String senhaCriptografada = passwordEncoder.encode(psicologoDto.getSenhaHash());
        psicologo.setSenhaHash(senhaCriptografada);
        psicologo.setCrp(psicologoDto.getCrp());
        psicologo.setTelefone(psicologoDto.getTelefone());
        psicologo.setAtivo(psicologoDto.isAtivo());

        psicologoRepository.save(psicologo);
        
    }

    private PsicologoResponseDTO toDto(Psicologo psicologo) {
        return new PsicologoResponseDTO(
            psicologo.getId(),
            psicologo.getNome(),
            psicologo.getCpf(),
            psicologo.getEmail(),
            psicologo.isAtivo(),
            psicologo.getEspecialidade(),
            psicologo.getTelefone(),
            psicologo.getCrp()   
        );
    }

   
}
