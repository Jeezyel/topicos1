package br.unitins.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Compra extends DefaultEntity{

    private Date data;
    private Double totalCompra;
    @OneToMany
    private List<ItemCompra> itemCompra;
    @OneToOne
    private Endereco endereco;
    @OneToMany
    private List<Cliente> cliente;


    
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
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
