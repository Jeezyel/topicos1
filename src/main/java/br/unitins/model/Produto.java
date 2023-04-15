package br.unitins.model;

import javax.persistence.Column;

public abstract class Produto extends DefaultEntity {
    @Column(nullable = true , length = 20)
    private String modelo;
    @Column(nullable = true , length = 20)
    private String marca;
    private String cor;
    private Integer quantidade;
    private Float valor;





    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
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
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }




}