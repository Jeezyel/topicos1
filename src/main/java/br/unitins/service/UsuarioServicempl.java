package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.UsuarioDTO;
import br.unitins.dto.UsuarioResponseDTO;
import br.unitins.model.Roupas;
import br.unitins.model.Usuario;
import br.unitins.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioServicempl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDTO> getAll() {

        List<Usuario> listaUsuarios =  (List<Usuario>) usuarioRepository.findAll();

        return listaUsuarios.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public UsuarioResponseDTO insert(UsuarioDTO usuarioDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void delete(String login) {

        usuarioRepository.deleteForLogin(login);
    }

    @Override
    public void deleteProdutoFromListaDesejo(Long id, Long idProduto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProdutoFromListaDesejo'");
    }

    @Override
    public void deleteProdutoFromListaDesejo(Roupas roupas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProdutoFromListaDesejo'");
    }

    @Override
    public Long count() {
        
        return usuarioRepository.count();
    }

    @Override
    public List<UsuarioResponseDTO> getByNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByNome'");
    }

    @Override
    public Usuario getByLoginAndSenha(String login, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByLoginAndSenha'");
    }

    @Override
    public List<UsuarioResponseDTO> getByLogins(String login) {
        

        List<Usuario> usuario = usuarioRepository.findByNomeList(login);

        return usuario.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());

    }


    public UsuarioResponseDTO getByLogin(String login) {
        
        Usuario usuario = (Usuario) usuarioRepository.findByNome(login);

        return new UsuarioResponseDTO(usuario);

    }

    public Usuario getByLoginUsuario(String login) {
        
        Usuario usuario = (Usuario) usuarioRepository.findByNome(login);

        return usuario;

    }

    @Override
    public void update(Long id, UsuarioDTO dadosPessoaisDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void update(Long id, EnderecoDTO enderecoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void update(Long id, String nomeImagem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void updateTelefonePrincipal(Long id, TelefoneDTO telefonePrincipalDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTelefonePrincipal'");
    }

    @Override
    public void updateTelefoneOpcional(Long id, TelefoneDTO telefoneOpcionalDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTelefoneOpcional'");
    }

    @Override
    public Integer countListaDesejo(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countListaDesejo'");
    }
    
}
