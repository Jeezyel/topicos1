package br.unitins.model;

import javax.persistence.Entity;

@Entity
public class ItemCompra extends DefaultEntity {

    private Integer quantidade;
    private Double preco;
    private Roupas roupas;

    
    
    public Roupas getRoupas() {
        return roupas;
    }
    public void setRoupas(Roupas roupas) {
        this.roupas = roupas;
    }
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

}
