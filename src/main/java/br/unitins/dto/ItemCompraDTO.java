package br.unitins.dto;

public class ItemCompraDTO {

    private Integer quantidade;
    private Double preco;
    private RoupasDTO roupas;

    
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
    public RoupasDTO getRoupas() {
        return roupas;
    }
    public void setRoupas(RoupasDTO roupas) {
        this.roupas = roupas;
    }

    

}
