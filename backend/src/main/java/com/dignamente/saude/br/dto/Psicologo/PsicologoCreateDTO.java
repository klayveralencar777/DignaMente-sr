package com.dignamente.saude.br.dto.Psicologo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PsicologoCreateDTO {
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Email inválido, tente outro.")
    private String email;

    @NotBlank(message = "Senha é obrigatória.")
    private String senhaHash;

    @NotBlank(message = "CPF é obrigatório.")
    private String cpf;

    
    private boolean ativo;

    @NotBlank(message = "Telefone é obrigatório.")
    private String telefone;

    @NotBlank(message = "CRP é obrigatório.")
    private String crp;

    @NotBlank(message = "Especialidade é obrigatória.")
    private String especialidade;
    
}
