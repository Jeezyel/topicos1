package br.unitins.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Roupas extends PanacheEntity {

   // @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private Float valor;
    private String cor;
    @Column(nullable = false , length = 40)
    private String tipoDeTercido;
    @Column(nullable = true , length = 20) // esse true pode dar problemas fica de olha 
    private String marca;
    @Column(nullable = true , length = 20)// esse true pode dar problemas fica de olha 
    private String modelo;
    /*private Cliente cliente;



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }*/

    public String getModelo() {
        return modelo;
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoDeTercido() {
        return tipoDeTercido;
    }

    public void setTipoDeTercido(String tipoDeTercido) {
        this.tipoDeTercido = tipoDeTercido;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

}
