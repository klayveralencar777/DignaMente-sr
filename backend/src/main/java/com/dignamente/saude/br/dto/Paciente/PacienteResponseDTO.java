package com.dignamente.saude.br.dto.Paciente;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class PacienteResponseDTO{
    private UUID id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String telefone;
    private String cpf;
    private Boolean ativo = true;

}
    

     
   

