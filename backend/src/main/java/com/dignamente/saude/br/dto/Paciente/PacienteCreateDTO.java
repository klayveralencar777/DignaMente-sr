package com.dignamente.saude.br.dto.Paciente;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PacienteCreateDTO {

    private String nome;
    private String email;
    private String senhaHash;
    private LocalDate dataNascimento;
    private String telefone;
    private String cpf;
    private Boolean ativo;

}
