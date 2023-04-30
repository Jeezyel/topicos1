package br.unitins.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
