package com.contas.apirest.apirest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contas.apirest.apirest.Model.Contas;



public interface ContasRepository extends JpaRepository <Contas, Long>{
    
 
}