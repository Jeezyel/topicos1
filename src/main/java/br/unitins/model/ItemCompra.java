package br.unitins.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ItemCompra extends DefaultEntity {
    
    private Integer quantidadeProduto;
    private Double preco;
    @OneToMany
    private List<Roupas> roupas;

    
    
    
    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
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
