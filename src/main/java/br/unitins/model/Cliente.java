package br.unitins.model;



public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private LocalEntrega localEnterga;




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalEntrega getLocalEnterga() {
        return localEnterga;
    }
    public void setLocalEnterga(LocalEntrega localEnterga) {
        this.localEnterga = localEnterga;
    }



}
