package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.dto.EstadosDTO;
import br.unitins.dto.EstadosResponseDTO;
import br.unitins.model.Estados;
import br.unitins.repository.EstadoRepository;
import br.unitins.repository.MunicipioRepository;

public class EstadoServicempl implements EstadoService{

    @Inject
    MunicipioRepository municipioRepository;

    @Inject
    EstadoRepository estadoRepository;

    @Inject
    Validator validator;

    @Override
    public List<EstadosResponseDTO> getAll() {
        
        List<Estados> list = estadoRepository.listAll();
        return list.stream().map(EstadosResponseDTO::new).collect(Collectors.toList());

    }

    @Override
    public EstadosResponseDTO findById(Long id) {

        Estados estados = estadoRepository.findById(id);
        if (estados == null)
            throw new NotFoundException("Município não encontrado.");
        return new EstadosResponseDTO(estados);
    }

    @Override
    public EstadosResponseDTO create(EstadosDTO estadosDTO) {
        validar(estadosDTO);

        Estados entity = new Estados();
        entity.setNome(estadosDTO.nome());
        entity.setSigla(estadosDTO.sigla());
        entity.setMunicipio(municipioRepository.findById(estadosDTO.id()));

        estadoRepository.persist(entity);

        return new EstadosResponseDTO(entity);


    }

    @Override
    public EstadosResponseDTO update(Long id, EstadosDTO estadosDTO) {
        validar(estadosDTO);

        Estados entity = estadoRepository.findById(id);

        entity.setNome(estadosDTO.nome());
        entity.setSigla(estadosDTO.sigla());
        entity.setMunicipio(municipioRepository.findById(estadosDTO.id()));
        estadoRepository.persist(entity);

        return new EstadosResponseDTO(entity);
    }

    @Override
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

    @Override
    public List<EstadosResponseDTO> findByNome(String nome) {
        
        List<Estados> list = estadoRepository.findByNome(nome);
        return list.stream().map(EstadosResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {

        return estadoRepository.count();
    }

    private void validar(EstadosDTO estadosDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<EstadosDTO>> violations = validator.validate(estadosDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);


    }
    
}
