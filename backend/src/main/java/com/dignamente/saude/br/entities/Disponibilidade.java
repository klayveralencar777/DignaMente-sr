package com.dignamente.saude.br.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dignamente.saude.br.enums.StatusDisponibilidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"psicologo_id", "inicio", "fim"})
)
@Getter
@Setter
@NoArgsConstructor
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Início da disponibilidade é obrigatório.")
    @Column(nullable = false)
    private LocalDateTime inicio;

    @NotNull(message = "Fim da disponibilidade é obrigatório.")
    @Column(nullable = false)
    private LocalDateTime fim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDisponibilidade status = StatusDisponibilidade.DISPONIVEL;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull(message = "Psicólogo é obrigatório.")
    private Psicologo psicologo;
}
