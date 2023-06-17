package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Cliente;
import br.unitins.model.Perfil;

public record ClienteSimplesResponseDTO (

    String cpf,
    String nome,
    String login,
    String senha,
    Set<Perfil> perfis
) {
    public ClienteSimplesResponseDTO(Cliente cliente){

        this(cliente.getCpf(),
        cliente.getNome(),
        cliente.getLogin(),
        cliente.getSenha(),
        cliente.getPerfis());
        
    }

    
}
