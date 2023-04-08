package br.unitins.model;

import java.util.Date;

public class Compra {

    private long id;
    private Date data;
    private Double totalCompra;
    private ItemCompra itemCompra;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
    public ItemCompra getItemCompra() {
        return itemCompra;
    }
    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }
}
