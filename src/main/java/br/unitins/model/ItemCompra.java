package br.unitins.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ItemCompra extends DefaultEntity {
    
    private Integer quantidade;
    private Double preco;
    @OneToMany
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
