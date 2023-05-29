package br.unitins.service;

import java.util.List;

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Roupas;
import br.unitins.model.Usuario;

public interface UsuarioService {
        // Metodos basicos

        List<UsuarioResponseDTO> getAll();

        UsuarioResponseDTO getById(Long id);
    
        UsuarioResponseDTO insert(UsuarioDTO usuarioDto);
    
        void delete(Long id);
    
        void deleteProdutoFromListaDesejo(Long id, Long idProduto);
    
        void deleteProdutoFromListaDesejo(Roupas roupas);
    
        // Metodos extras
    
        Long count();
    
        List<UsuarioResponseDTO> getByNome(String nome);
    
        Usuario getByLoginAndSenha(String login, String senha);
    
        Usuario getByLogin(String login);
    
        void update(Long id, UsuarioDTO dadosPessoaisDTO);
    
        void update(Long id, EnderecoDTO enderecoDTO);
    
        void update(Long id, String nomeImagem);
    
        void updateTelefonePrincipal(Long id, TelefoneDTO telefonePrincipalDTO);
    
        void updateTelefoneOpcional(Long id, TelefoneDTO telefoneOpcionalDTO);
    
        Integer countListaDesejo(Long id);
}
