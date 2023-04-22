package br.unitins.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class ItemCompra extends DefaultEntity {

    private Integer quantidade;
    private Double preco;
    @ManyToMany
    private List<Roupas> roupas;

    
    
    
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public List<Roupas> getRoupas() {
        return roupas;
    }
    public void setRoupas(List<Roupas> roupas) {
        this.roupas = roupas;
    }

}
