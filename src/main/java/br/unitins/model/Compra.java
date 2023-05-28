package br.unitins.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Compra extends DefaultEntity{

    private Double totalCompra;
    @OneToMany
    private List<ItemCompra> itemCompra;
    @OneToOne
    private Endereco endereco;
    @OneToMany
    private List<Cliente> cliente;
    @OneToOne
    private Comprovante comprovante;


    
    
    public Comprovante getComprovante() {
        return comprovante;
    }
    public void setComprovante(Comprovante comprovante) {
        this.comprovante = comprovante;
    }
    public Double getTotalCompra() {
        return totalCompra;
    }
    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }
    public List<ItemCompra> getItemCompra() {
        return itemCompra;
    }
    public void setItemCompra(List<ItemCompra> itemCompra) {
        this.itemCompra = itemCompra;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public List<Cliente> getCliente() {
        return cliente;
    }
    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }
}
