package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.service.ClienteService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.dto.FinalizarCadastroDTO;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResouce {

    
    private static final Logger LOG = Logger.getLogger(ClienteResouce.class);

    @Inject
    ClienteService service;

    @Inject
    JsonWebToken tokenJwt;


    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin"})
    public List<ClienteResponseDTO> getAll(){
        LOG.info("buscnado todos os clientes");
        return service.getAll();
    }

    @GET
    @Path("/searchForId/{Id}")
    @RolesAllowed({"Admin","User"})
    public ClienteResponseDTO searchForId(@PathParam("Id") Long Id){

        LOG.info("buscnado clientes por id");
        return service.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @RolesAllowed({"Admin"})
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO clienteDTO) {
        LOG.info("criando clientes");
        return service.create(clienteDTO);
    }
    // update
    @POST
    @Path("/update/{login}")
    @RolesAllowed({"Admin","User"})
    @Transactional
    public ClienteResponseDTO update(@PathParam("login") String login, ClienteDTO clienteDTO) {

        LOG.info("atualizando o clientes selecionado pelo id");
        
        return service.update(login , clienteDTO);
    }

    @POST
    @Path("/finalizar-cadastro")
    @RolesAllowed({"Admin","User" , "Cliente"})
    @Transactional
    public ClienteResponseDTO FinalizarCasdastro(FinalizarCadastroDTO clienteDTO) {

        LOG.info("atualizando o clientes selecionado pelo id");

        String login = tokenJwt.getSubject();
        
        return service.FinalizarCasdastro(login , clienteDTO);
    }


    @DELETE
    @Path("/deleteForId/{Id}")
    @RolesAllowed({"Admin"})
    public void DeleteForId(@PathParam("Id") long id){

        LOG.info("selecionado o cliente e apagando o cadastro");
        service.delete(id);
    }

    @GET
    @Path("/count")
    @RolesAllowed({"Admin"})
    public long count(){
        LOG.info("count");
        return service.count();
    }

    @GET
    @Path("/searchForName/{name}")
    @RolesAllowed({"Admin","User"})
    public ClienteResponseDTO searchForName(@PathParam("name") String name){

        LOG.info("procurando por nome do cliente");
        return service.findByNome(name);
    }

    
}
