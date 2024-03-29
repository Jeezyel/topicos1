package br.unitins.dto;

public abstract class ProdutoDTO {

    private long id;
    private String modelo;
    private String marca;
    private String cor;
    private Integer quantidade;
    private Float valor;
    private String nomeImagen;

    
    public String getNomeImagen() {
        return nomeImagen;
    }
    public void setNomeImagen(String nomeImagen) {
        this.nomeImagen = nomeImagen;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setMarca(String marca) {
        this.marca = marca;
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

    
}
