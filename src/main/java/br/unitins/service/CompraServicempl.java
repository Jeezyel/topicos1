package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.aplication.Result;
import br.unitins.dto.CompraResponseDTO;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.model.Compra;
import br.unitins.model.Usuario;
import br.unitins.repository.CompraRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import jakarta.ws.rs.core.Response.Status;

public class CompraServicempl implements CompraService{

    @Inject
    CompraRepository compraRepository;
    
    @Inject
    UsuarioServicempl usuarioService;

    @Inject
    JsonWebToken tokenJwt;

    @Override
    public List<CompraResponseDTO> getAll(Long idUsuario) {

        List<Compra> listaCompra = compraRepository.listAll();

        return listaCompra.stream().map(CompraResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public CompraResponseDTO getCompraEmAndamento(String loginn) {

        String login = tokenJwt.getSubject();



        Usuario usuario = usuarioService.getByLoginUsuario(loginn);

        try {

            return Response.ok(compraRepository.getCompraEmAndamento(usuario.getId())).build();
            
        } catch (NullPointerException e) {

            Result result = new Result(e.getMessage(), false);

            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @Override
    public void insertItemIntoCompra(Long idCompra, ItemCompraDTO itemCompraDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertItemIntoCompra'");
    }

    @Override
    public void removeItemCompra(Long idUsuario, Long idItemCompra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemCompra'");
    }

    @Override
    public void finishCompra(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishCompra'");
    }
    
}
