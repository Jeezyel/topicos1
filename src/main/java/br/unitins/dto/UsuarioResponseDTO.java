package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Cliente;
import br.unitins.model.Perfil;

public record UsuarioResponseDTO(
    String login,
String senha,
String nomeImagem,
Set<Perfil> perfis) {
    
    UsuarioResponseDTO(Cliente cliente){
        this(cliente.getLogin(),cliente.getSenha(),cliente.getNomeImagem(), cliente.getPerfis());
    }

    
}
