package com.contas.apirest.apirest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contas.apirest.apirest.Model.Usuario;

public interface UsuarioRepository extends JpaRepository < Usuario, Long>{
    
    List<Usuario> findById(long id);

}
