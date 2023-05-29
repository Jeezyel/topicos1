package br.unitins.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Comprovante extends DefaultEntity {
    @OneToOne
    private Compra compra;
    private String nomePagador;
    private String nomeUsuario;
    private String cpfpagador;
  /*  private List<ItemCompra> itemCompra;




    public List<ItemCompra> getItemCompra() {
        return itemCompra;
    }
    public void setItemCompra(List<ItemCompra> itemCompra) {
        this.itemCompra = itemCompra;
    }*/
    public String getNomePagador() {
        return nomePagador;
    }
    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getCpfpagador() {
        return cpfpagador;
    }
    public void setCpfpagador(String cpfpagador) {
        this.cpfpagador = cpfpagador;
    }
    public Compra getCompra() {
        return compra;
    }
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
}
