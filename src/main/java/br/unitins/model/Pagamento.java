package br.unitins.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento extends DefaultEntity {

    @OneToOne
    private Compra compra;
    private Integer quantidadeParcela = 1;
    private Double valorParcela;
    private TipoPagamento tipoPagamento;
    private Boolean confirmarPagamento = false;









    public Boolean getConfirmarPagamento() {
        return confirmarPagamento;
    }
    public void setConfirmarPagamento(Boolean confirmarPagamento) {

        //colocar o metodo finalizar compra aqui so fazer um if caso for true chama o metodo caso não, não faz nada  
        this.confirmarPagamento = confirmarPagamento;
    }
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    public Compra getCompra() {
        return compra;
    }
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }
    public void setQuantidadeParcela(Integer quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }
    public Double getValorParcela() {
        return valorParcela;
    }
    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    
}
