
package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

import org.jboss.logging.Logger;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.dto.ClienteSimplesDTO;
import br.unitins.dto.ClienteSimplesResponseDTO;
import br.unitins.dto.FinalizarCadastroDTO;
import br.unitins.model.Cliente;
import br.unitins.repository.ClienteRepository;
import br.unitins.repository.UsuarioRepository;

@ApplicationScoped
public class ClienteServicempl  implements ClienteService{

    private static final Logger LOG = Logger.getLogger(ClienteServicempl.class);

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    HashService hashService;


    @Inject
    Validator validator;

    @Override
    public List<ClienteResponseDTO> getAll() {
        LOG.debug("buscando cliente no banco e colocando na lista ");
        List<Cliente> listaCliente = clienteRepository.listAll();

        LOG.debug("convertendo a lista para ser retornada ");
        return listaCliente.stream().map(ClienteResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO findById(Long id) {

        LOG.debug("buscando o cliente no banco ");
        Cliente cliente = clienteRepository.findById(id);

        LOG.debug("verificando se não esta null ");
        if(cliente == null){
            LOG.debug("dando uma mensagen de erro caso não encontrado ");
            throw new NotFoundException("Cliente nao encontrado ");
        }
        LOG.debug("convertendo e retornando ");
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO create(ClienteDTO clienteDTO) throws ConstraintViolationException{
        validar(clienteDTO);

        Cliente cliente = new Cliente();

        cliente.setCpf(clienteDTO.cpf());
        cliente.setNome(clienteDTO.nome());
        cliente.setEndereco(clienteDTO.enderecos());
        cliente.setTelefone(clienteDTO.telefone());
        cliente.setLogin(clienteDTO.login());
        cliente.setSenha(clienteDTO.senha());
        cliente.setNomeImagem(clienteDTO.nomeImagem());
        cliente.setPerfis(clienteDTO.perfis());

        clienteRepository.persist(cliente);

        return new ClienteResponseDTO(cliente);

    }

    @Override
    public ClienteResponseDTO update(String login, ClienteDTO clienteDTO) throws ConstraintViolationException{
        LOG.debug("validando o dto ");
        validar(clienteDTO);

        LOG.debug("buscando o cliente ");
        Cliente cliente = clienteRepository.findByLogin(login);

        LOG.debug("modificando os dados do cliente ");

        cliente.setCpf(clienteDTO.cpf());
        cliente.setNome(clienteDTO.nome());
        cliente.setEndereco(clienteDTO.enderecos());
        cliente.setTelefone(clienteDTO.telefone());
        cliente.setLogin(clienteDTO.login());
        cliente.setNomeImagem(clienteDTO.nomeImagem());
        cliente.setPerfis(clienteDTO.perfis());


        LOG.debug("mandando para o banco ");
        clienteRepository.persist(cliente);


        LOG.debug("retornando os dados atualizados");
        return new ClienteResponseDTO(cliente);
    }


    @Override
    public void delete(Long id) {
        LOG.debug("deletando dentro do clienteServicempl ");
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findByNome(String nome) {

        
        LOG.debug("buscando o cliente no banco ");
        Cliente listaCliente = clienteRepository.findByNome(nome);

        
        LOG.debug("convertendo e retornando ");
        return new ClienteResponseDTO(listaCliente);
    }

    @Override
    public long count() {
        LOG.debug("count dentro do clienteServicempl ");
        return clienteRepository.count();
    }

    private void validar(ClienteDTO clienteDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<ClienteDTO>> violations = validator.validate(clienteDTO);

        LOG.debug("verificando se ja foi criado ");
        if (!violations.isEmpty()){

            LOG.debug("retornando uma Exception ");
            throw new ConstraintViolationException(violations);
        }


    }

    @Override
    public Boolean alterarSenha(String login, String senhaAtual, String novaSenha) {


        LOG.debug("buscando no banco ");
        Cliente  usuario = usuarioRepository.findByLogin(login);
        String senhaAt = hashService.getHashSenha(senhaAtual);
        LOG.debug("verificando se a senha esta correta");
        if (usuario.getSenha() != senhaAt ) {
            return false;
        }
        else{
            LOG.debug("atualizando a senha para a nova senha");
            usuario.setSenha(senhaAt);

            return true ;
        }

        
    }

    @Override
    public Boolean alterarSenha(long id, String senhaAtual, String novaSenha) {
        
        LOG.debug("buscando no banco ");
        Cliente  usuario = usuarioRepository.findById(id);
        String senhaAt = hashService.getHashSenha(senhaAtual);
        LOG.debug("verificando se a senha esta correta");
        if (usuario.getSenha() != senhaAt ) {
            return false;
        }
        else{
            LOG.debug("atualizando a senha para a nova senha");
            usuario.setSenha(novaSenha);

            return true ;
        }
    }

    @Override
    public Cliente findByLogin(String login) {

        Cliente cliente = clienteRepository.findByLogin(login);

        return cliente;
    }

    @Override
    public Cliente findByLoginCli(String login) {
        Cliente cliente = clienteRepository.findByLogin(login);

        return cliente;
    }

    @Override
    public void deleteByLogin(String login) {
        Cliente cliente = clienteRepository.findByLogin(login);

        clienteRepository.delete(cliente);
    }

    @Override
    @Transactional
    public ClienteResponseDTO updateNomeImagen(Long idCliente, String nomeImagen) {

        Cliente cliente = clienteRepository.findById(idCliente);

        cliente.setNomeImagem(nomeImagen);

        //clienteRepository.persist(cliente);

        return new ClienteResponseDTO(cliente);

    }

    @Override
    public Cliente findByLoginAndSenha(String login, String hash) throws NullPointerException {
 
        String senha = hashService.getHashSenha(hash);
        
        return clienteRepository.findByLoginAndSenha(login, senha);
        
        
    }

    @Override
    public ClienteSimplesResponseDTO createSimplis(ClienteSimplesDTO clienteSimplisDTO) {
        Cliente cliente = new Cliente(); 

        cliente.setCpf(clienteSimplisDTO.cpf());
        cliente.setNome(clienteSimplisDTO.nome());
        cliente.setLogin(clienteSimplisDTO.login());
        cliente.setSenha(hashService.getHashSenha(clienteSimplisDTO.senha()));
        cliente.setPerfis(clienteSimplisDTO.perfis());

        clienteRepository.persist(cliente);

        return new ClienteSimplesResponseDTO(cliente);
    }

    @Override
    public Cliente findByIdCli(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteResponseDTO FinalizarCasdastro(String login, FinalizarCadastroDTO clienteDTO) {
        Cliente cliente = clienteRepository.findByLogin(login);

        cliente.setEndereco(clienteDTO.enderecos());
        cliente.setTelefone(clienteDTO.telefone());

        clienteRepository.persist(cliente);


        return new ClienteResponseDTO(cliente);
    }

    
}
