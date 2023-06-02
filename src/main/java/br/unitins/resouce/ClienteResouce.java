package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.service.ClienteService;
import jakarta.inject.Inject;
import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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


    @GET
    @Path("/getAll")
    public List<ClienteResponseDTO> getAll(){
        LOG.info("buscnado todos os clientes");
        return service.getAll();
    }

    @GET
    @Path("/searchForId/{Id}")
    public ClienteResponseDTO searchForId(@PathParam("Id") Long Id){

        LOG.info("buscnado todos os clientes por id");
        return service.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO clienteDTO) {
        LOG.info("criando clientes");
        return service.create(clienteDTO);
    }
    // update
    @POST
    @Path("/update/{id}")
    @Transactional
    public ClienteResponseDTO update(@PathParam("id") Long id, ClienteDTO clienteDTO) {

        LOG.info("atualizando o clientes selecionado pelo id");
        
        return service.update(id , clienteDTO);
    }

    @PATCH
    @Path("/alterarSenha/{id}{senhaAtual}{novaSenha}")
    public boolean AlterarSenha (@PathParam("id") Long id,@PathParam("senhaAtual") String senhaAtual, @PathParam("novaSenha") String novaSenha){

        LOG.info("buscando o cliente e alterando a senha ");

        return service.alterarSenha(id, senhaAtual, novaSenha) ;
    }

    @DELETE
    @Path("/deleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){

        LOG.info("selecionado o cliente e apagndo o cadastro");
        service.delete(id);
    }

    @GET
    @Path("/count")
    public long count(){
        LOG.info("count");
        return service.count();
    }

    @GET
    @Path("/searchForName/{name}")
    public List<ClienteResponseDTO> searchForName(@PathParam("name") String name){

        LOG.info("procurando por nome do cliente");
        return service.findByNome(name);
    }

    
}
