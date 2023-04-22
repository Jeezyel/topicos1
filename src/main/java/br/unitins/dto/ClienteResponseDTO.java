package br.unitins.dto;

import java.util.List;

import br.unitins.model.Cliente;
import br.unitins.model.Endereco;
import br.unitins.model.Roupas;
import br.unitins.model.Telefone;

public record ClienteResponseDTO (

    String cpf,
    String nome,
    List<Endereco> endereco,
    List<Telefone> telefone,
    List<Roupas> listaDeDesejo
) {
    public ClienteResponseDTO(Cliente cliente){

        this(cliente.getCpf(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(),cliente.getListaDeDesejo());
        
    }

    
}
