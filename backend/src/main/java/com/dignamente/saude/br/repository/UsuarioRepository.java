package com.dignamente.saude.br.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dignamente.saude.br.entities.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
}
