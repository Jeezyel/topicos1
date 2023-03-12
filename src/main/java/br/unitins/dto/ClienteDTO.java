package br.unitins.dto;

public class ClienteDTO {

    private String nome;
    private LocalEntregaDTO localEnterga;


    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalEntregaDTO getLocalEnterga() {
        return localEnterga;
    }
    public void setLocalEnterga(LocalEntregaDTO localEnterga) {
        this.localEnterga = localEnterga;
    }

}
