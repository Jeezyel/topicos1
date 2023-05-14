package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Roupas extends Produto {

   // @Id
    @Column(nullable = false , length = 40)
    private String tipoDeTercido;
    @Column(nullable = false)
    private Tamanho tamanho;
/*
 */

    
 
    

    public String getTipoDeTercido() {
        return tipoDeTercido;
    }

    public void setTipoDeTercido(String tipoDeTercido) {
        this.tipoDeTercido = tipoDeTercido;
    }



}
