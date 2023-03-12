package br.unitins.dto;

import br.unitins.model.Roupas;

public class RoupasResouserDTO {

    private Integer quantidade;
    private Float valor;
    private String cor;
    private String marca;
    private String modelo;


    
    public RoupasResouserDTO(Roupas roupas) {
        this.quantidade =roupas.getQuantidade();
        this.valor = roupas.getValor();
        this.cor = roupas.getCor();
        this.marca = roupas.getMarca();
        this.modelo = roupas.getModelo();
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Float getValor() {
        return valor;
    }
    public void setValor(Float valor) {
        this.valor = valor;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    
}
