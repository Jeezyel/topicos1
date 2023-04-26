package br.unitins.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Roupas extends Produto {

   // @Id
    @Column(nullable = false , length = 40)
    private String tipoDeTercido;
    @ManyToMany
    private List<Cliente> ListaDeDesejo;
    @OneToMany
    private Tamanho tamanho;



    
 
    

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
