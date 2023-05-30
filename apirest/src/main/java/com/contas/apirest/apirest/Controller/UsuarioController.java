package com.contas.apirest.apirest.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contas.apirest.apirest.Model.Usuario;
import com.contas.apirest.apirest.Repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
    
    //Fiz um injeção do repository
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    //Nesse metodo fiz um mapeamento de url na hora de salvar um dado
    @PostMapping(value = "/user")
    public Usuario insert(@RequestBody Usuario usuario){

        return usuarioRepository.save(usuario);
    }


    //Nesse metodo fiz um mapeamento ao listar dados
    @GetMapping(value = "/users")
    public  List<Usuario> findAll(){

        List<Usuario> users = usuarioRepository.findAll();

        return users;
    }

    //Fazendo busca no banco passando o ID
    @GetMapping(value = "/user/{id}")
    public Usuario findById(@PathVariable long id){

        Usuario user = usuarioRepository.findById(id).get(0);

        return user;
    }

    //deletando um registro da base de dados
    @DeleteMapping("/user/{id}")
    public String apagandoRegistro(@PathVariable("id")Long id){

        usuarioRepository.deleteById(id);
        return "Registro deletado com Sucesso!";
    }

}