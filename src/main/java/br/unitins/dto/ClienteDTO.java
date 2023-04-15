package br.unitins.dto;

import java.util.List;

public class ClienteDTO {

    private Long id;
    private String cpf;
    private String nome;
    private List<EnderecoDTO> localEnterga;
    private TelefoneDTO telefone;   



    
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
    public List<EnderecoDTO> getLocalEnterga() {
        return localEnterga;
    }
    public void setLocalEnterga(List<EnderecoDTO> localEnterga) {
        this.localEnterga = localEnterga;
    }
    public TelefoneDTO getTelefone() {
        return telefone;
    }
    public void setTelefone(TelefoneDTO telefone) {
        this.telefone = telefone;
    }


    
    

}
