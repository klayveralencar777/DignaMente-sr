package com.dignamente.saude.br.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Psicologo extends Usuario {

    @NotBlank(message = "CRP é obrigatório.")
    @Column(nullable = false, unique = true)
    private String crp;

    @NotBlank(message = "Especialidade é obrigatória.")
    @Column(nullable = false)
    private String especialidade;

    @Column(nullable = false)
    private boolean ativo = true;

    @OneToMany(mappedBy = "psicologo")
    private List<Disponibilidade> disponibilidades = new ArrayList<>();
}
