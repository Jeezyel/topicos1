package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Cliente;
import br.unitins.model.Perfil;
import br.unitins.model.Usuario;

public record UsuarioResponseDTO(
String login,
String senha,
String nomeImagem,
Set<Perfil> perfis,
Cliente cliente
) {
    public UsuarioResponseDTO(Usuario usuario){

        this(usuario.getLogin(), usuario.getSenha(), usuario.getNomeImagem(), usuario.getPerfis(), usuario.getCliente());
        
    }
    
}
