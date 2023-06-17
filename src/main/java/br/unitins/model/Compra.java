package br.unitins.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Compra extends DefaultEntity{

    @Column( nullable = false )    
    private Double totalCompra; 
    @OneToOne
    private ItemCompra itemCompra; 
    @OneToOne
    private Endereco endereco;
    
    @OneToOne
    private Cliente cliente;


    
    
    
    public Double getTotalCompra() {
        return totalCompra;
    }
    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public ItemCompra getItemCompra() {
        return itemCompra;
    }
    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
