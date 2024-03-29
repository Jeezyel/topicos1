package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Cliente;
import br.unitins.model.Endereco;
import br.unitins.model.Perfil;
import br.unitins.model.Telefone;

public record ClienteResponseDTO (

    long id,
    String cpf,
    String nome,
    Endereco enderecos,
    Telefone telefone,
    String login,
    String senha,
    String nomeImagem,
    Set<Perfil> perfis
) {
    public ClienteResponseDTO(Cliente cliente){

        this(cliente.getId(),
            cliente.getCpf(),
            cliente.getNome(),
            cliente.getEndereco(),
            cliente.getTelefone(),
            cliente.getLogin(),
            cliente.getSenha(),
            cliente.getNomeImagem(),
            cliente.getPerfis());
        
    }

    
}
