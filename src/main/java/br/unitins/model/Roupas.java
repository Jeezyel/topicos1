package br.unitins.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Roupas extends Produto {

   // @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , length = 40)
    private String tipoDeTercido;
    @ManyToMany
    private List<Cliente> ListaDeDesejo;
    @ManyToOne
    private Tamanho tamanho;



    
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
