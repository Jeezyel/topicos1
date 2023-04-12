package br.unitins.dto;

import java.util.Date;
import java.util.List;

public class CompraDTO {
    
    private Date data;
    private Double totalCompra;
    private List<ItemCompraDTO> itemCompra;
    private List<EnderecoDTO> endereco;


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
    public List<ItemCompraDTO> getItemCompra() {
        return itemCompra;
    }
    public void setItemCompra(List<ItemCompraDTO> itemCompra) {
        this.itemCompra = itemCompra;
    }
    public List<EnderecoDTO> getEndereco() {
        return endereco;
    }
    public void setEndereco(List<EnderecoDTO> endereco) {
        this.endereco = endereco;
    }

    
    
}
