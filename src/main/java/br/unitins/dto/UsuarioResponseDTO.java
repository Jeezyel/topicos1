package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Cliente;
import br.unitins.model.Perfil;

public record UsuarioResponseDTO(
    long id,
    String login,
    String senha,
    String nomeImagem,
    Set<Perfil> perfis) {
    
    UsuarioResponseDTO(Cliente cliente){
        this(cliente.getId(),
            cliente.getLogin(),
            cliente.getSenha(),
            cliente.getNomeImagem(),
            cliente.getPerfis());
    }

/*    public static UsuarioResponseDTO valueOf(Cliente u) {
        if (u == null) 
            return new UsuarioResponseDTO(u.getId(), "null", "null", "null", u.getLogin(), "null", "null");
        
        return new UsuarioResponseDTO(
            u.getId(), 
            u.getLogin(), 
            u.getSenha(),
            u.getNomeImagem(),
            u.getPerfis()); 
    }*/

    
}
