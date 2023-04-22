package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;


import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.model.Cliente;
import br.unitins.repository.ClienteRepository;
import br.unitins.repository.TelefoneRepository;

@ApplicationScoped
public class ClienteServicempl  implements ClienteService{
    @Inject
    private ClienteRepository clienteRepository;

    @Inject 
    private TelefoneRepository telefoneRepository;

    @Inject
    Validator validator;

    @Override
    public List<ClienteResponseDTO> getAll() {
        List<Cliente> listaCliente = clienteRepository.listAll();

        return listaCliente.stream().map(ClienteResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id);

        if(cliente == null)
            throw new NotFoundException("Cliente nao encontrado ");
        return new ClienteResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO create(ClienteDTO clienteDTO) throws ConstraintViolationException{
        validar(clienteDTO);

        Cliente cliente = new Cliente();

        cliente.setCpf(clienteDTO.cpf());
        cliente.setNome(clienteDTO.nome());
        cliente.setEndereco(clienteDTO.enderecos());
        cliente.setTelefone(telefoneRepository.findByNumero(clienteDTO.telefone().getNumero()));
        cliente.setListaDeDesejo(clienteDTO.listaDeDesejo());

        clienteRepository.persist(cliente);

        return new ClienteResponseDTO(cliente);

    }

    @Override
    public ClienteResponseDTO update(Long id, ClienteDTO clienteDTO) throws ConstraintViolationException{
        validar(clienteDTO);

        Cliente cliente = clienteRepository.findById(id);

        cliente.setCpf(clienteDTO.cpf());
        cliente.setNome(clienteDTO.nome());
        cliente.setEndereco(clienteDTO.enderecos());
        cliente.setTelefone(telefoneRepository.findByNumero(clienteDTO.telefone().getNumero()));

        clienteRepository.persist(cliente);

        return new ClienteResponseDTO(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        List<Cliente> listaCliente = clienteRepository.findByNomeList(nome);

        return listaCliente.stream().map(ClienteResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return clienteRepository.count();
    }

    private void validar(ClienteDTO clienteDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<ClienteDTO>> violations = validator.validate(clienteDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
    
}
