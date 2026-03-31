package com.dignamente.saude.br.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dignamente.saude.br.entities.Psicologo;


@Repository
public  interface PsicologoRepository extends JpaRepository<Psicologo, UUID> {
    
}
