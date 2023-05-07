package br.unitins.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;


@Entity
public class Roupas extends Produto {

   // @Id
    @Column(nullable = false , length = 40)
    private String tipoDeTercido;
    @ManyToMany
    @JoinTable(name = "cliente_roupa",
    joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name = "roupa_id"))
    private List<Cliente> ListaDeDesejo;
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

    public List<Cliente> getListaDeDesejo() {
        return ListaDeDesejo;
    }

    public void setListaDeDesejo(List<Cliente> listaDeDesejo) {
        ListaDeDesejo = listaDeDesejo;
    }


}
