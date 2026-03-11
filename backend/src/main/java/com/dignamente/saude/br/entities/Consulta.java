package com.dignamente.saude.br.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dignamente.saude.br.enums.StatusConsulta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
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
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Início da consulta é obrigatório.")
    @Column(nullable = false)
    private LocalDateTime inicio;

    @NotNull(message = "Fim da consulta é obrigatório.")
    @Column(nullable = false)
    private LocalDateTime fim;

    @NotBlank(message = "Link da consulta é obrigatório.")
    @Column(nullable = false, unique = true)
    private String linkConsulta;

    @NotBlank(message = "Plataforma do link é obrigatória.")
    @Column(nullable = false)
    private String plataformaLink;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status = StatusConsulta.AGENDADA;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull(message = "Paciente é obrigatório.")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull(message = "Psicólogo é obrigatório.")
    private Psicologo psicologo;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    @NotNull(message = "Disponibilidade é obrigatória.")
    private Disponibilidade disponibilidade;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}

