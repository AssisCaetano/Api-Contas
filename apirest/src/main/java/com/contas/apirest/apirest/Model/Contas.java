package com.contas.apirest.apirest.Model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contas")
public class Contas implements Serializable {


    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String produto;
    private double precoProduto;
    private double qtdProduto;
    private double valor;
    private double qtdParcela;
    private double valorParcela;
    private double valorApagar;

    

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    
    public Contas() {
    
    }

    public Contas(long id, String produto, double precoProduto, double qtdProduto, double valor, double qtdParcela,
            double valorParcela, double valorApagar, Usuario usuario) {
        this.id = id;
        this.produto = produto;
        this.precoProduto = precoProduto;
        this.qtdProduto = qtdProduto;
        this.valor = valor;
        this.qtdParcela = qtdParcela;
        this.valorParcela = valorParcela;
        this.valorApagar = valorApagar;
        this.usuario = usuario;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduto() {
        return this.produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPrecoProduto() {
        return this.precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public double getQtdProduto() {
        return this.qtdProduto;
    }

    public void setQtdProduto(double qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public double getValor() {
        this.valor = this.precoProduto * this.qtdProduto;

        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQtdParcela() {
        return this.qtdParcela;
    }

    public void setQtdParcela(double qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public double getValorParcela() {
        this.valorParcela = this.valor / this.qtdParcela;
        return this.valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public double getValorApagar() {
        /*double total = 0.0;

        for(int x = 0; x < this.valorParcela; x++){
            total += this.getValorParcela();
        }
        System.out.println(total);
        */
        return this.valorApagar;
    }

    public void setValorApagar(double valorApagar) {
        this.valorApagar = valorApagar;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
}