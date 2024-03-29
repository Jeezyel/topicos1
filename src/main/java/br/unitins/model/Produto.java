package br.unitins.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto extends DefaultEntity {
    @Column(nullable = true )
    private String modelo;
    @Column(nullable = true)
    private String marca;
    @Column( nullable = false ) 
    private String cor;
    @Column( nullable = false ) 
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
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
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
