package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Roupas extends Produto {

    private Integer quantidade;
    @Column(nullable = false , length = 40)
    private String tipoDeTercido;
    @Column(nullable = false)
    private Tamanho tamanho;
/*
 */

    
 
    

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoDeTercido() {
        return tipoDeTercido;
    }

    public void setTipoDeTercido(String tipoDeTercido) {
        this.tipoDeTercido = tipoDeTercido;
    }



}
