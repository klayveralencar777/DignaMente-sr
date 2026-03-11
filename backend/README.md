# DignaMente

Aplicação Java com Spring Boot para cadastro de pacientes e psicólogos, gestão de disponibilidades e agendamento de consultas com link de atendimento.

## Tecnologias

- Java 17
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Bean Validation
- PostgreSQL
- Maven

## Modelagem de Domínio

O diagrama abaixo representa a modelagem UML atual do domínio.

```mermaid
classDiagram
    direction TB

    class Usuario {
        <<abstract>>
        - UUID id
        - String nome
        - String email
        - String senhaHash
        - String cpf
        - LocalDateTime createdAt
        - LocalDateTime updatedAt
        # onCreate()
        # onUpdate()
    }

    class Paciente {
        - String telefone
        - LocalDate dataNascimento
        - boolean ativo
    }

    class Psicologo {
        - String crp
        - String especialidade
        - boolean ativo
        - List~Disponibilidade~ disponibilidades
    }

    class Disponibilidade {
        - UUID id
        - LocalDateTime inicio
        - LocalDateTime fim
        - StatusDisponibilidade status
        - Psicologo psicologo
    }

    class Consulta {
        - UUID id
        - LocalDateTime inicio
        - LocalDateTime fim
        - String linkConsulta
        - String plataformaLink
        - StatusConsulta status
        - Paciente paciente
        - Psicologo psicologo
        - Disponibilidade disponibilidade
        - LocalDateTime createdAt
        - LocalDateTime updatedAt
        # onCreate()
        # onUpdate()
    }

    class StatusConsulta {
        <<enumeration>>
        AGENDADA
        CANCELADA
        REALIZADA
    }

    class StatusDisponibilidade {
        <<enumeration>>
        DISPONIVEL
        RESERVADA
        INDISPONIVEL
    }

    Usuario <|-- Paciente
    Usuario <|-- Psicologo

    Psicologo "1" --> "0..*" Disponibilidade : possui
    Paciente "1" --> "0..*" Consulta : agenda
    Psicologo "1" --> "0..*" Consulta : atende
    Consulta "1" --> "1" Disponibilidade : reserva

    Consulta --> StatusConsulta
    Disponibilidade --> StatusDisponibilidade
```

## Regras Centrais do Domínio

- `Paciente` e `Psicologo` herdam de `Usuario`.
- `Psicologo` publica horários disponíveis por meio de `Disponibilidade`.
- `Consulta` vincula um `Paciente`, um `Psicologo` e uma `Disponibilidade` específica.
- Cada `Consulta` possui um `linkConsulta` e uma `plataformaLink`.
- O status da consulta é controlado por `StatusConsulta`.
- O status da disponibilidade é controlado por `StatusDisponibilidade`.

## Execução do Projeto

Para validar o projeto localmente, execute:

```powershell
.\mvnw.cmd test
```