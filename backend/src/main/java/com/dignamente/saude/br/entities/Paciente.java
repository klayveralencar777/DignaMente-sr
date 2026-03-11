package com.dignamente.saude.br.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Usuario {


    @NotNull(message = "Data de nascimento é obrigatória.")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private boolean ativo = true;
}
