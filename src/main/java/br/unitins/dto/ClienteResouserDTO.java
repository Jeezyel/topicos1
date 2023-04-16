package br.unitins.dto;

import java.util.List;

import br.unitins.model.Cliente;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

public record ClienteResouserDTO (

    String cpf,
    String nome,
    List<EnderecoDTO> endereco,
    TelefoneDTO telefone
) {
    public ClienteResouserDTO(Cliente cliente){

        this(cliente.getCpf(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone());
        
    }

    
}
