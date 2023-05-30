package com.contas.apirest.apirest.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contas.apirest.apirest.Model.Contas;
import com.contas.apirest.apirest.Repository.ContasRepository;

@RestController
@RequestMapping(value = "/api-contas")
public class ContasController {

    // injeção de dependcia do JpaRepository, trazendo tudo que preciso para o CRUD
    @Autowired
    private ContasRepository contasRepository;

    // Estou salvando um dado no banco
    @PostMapping(value = "/gasto")
    public Contas insert(@RequestBody Contas contas) {

        
        return contasRepository.save(contas);
    }

    // listando dodos do banco

    @GetMapping(value = "/gastos")
    public List<Contas> findAll() {
        List<Contas> compras = contasRepository.findAll();
        calculoDeContas();
        return compras;
    }

    // Deletando dados do banco
    @DeleteMapping("gasto/{id}")
    public String apagarRegistro(@PathVariable("id") Long id) {

        contasRepository.deleteById(id);

        return "Registro deletado com Sucesso!";
    }

    public double calculoDeContas(){
        double valorDoCarrinho = 0.0;
        List<Contas> cList = new ArrayList<>();

        
        for(int i = 0; i < cList.size(); i++){
            Contas conta = new Contas(0, null, 0, 0, 
            0, 0, 0, 0, null);
            cList.add(conta);

            valorDoCarrinho += conta.getValorParcela();
        }

        System.out.println(valorDoCarrinho);
        return valorDoCarrinho;
    }
}