package br.unitins.resouce;


import java.util.List;


import org.jboss.logging.Logger;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import br.unitins.dto.EstadosDTO;
import br.unitins.dto.EstadosResponseDTO;
import br.unitins.model.Estados;
import br.unitins.repository.EstadoRepository;
import br.unitins.service.EstadoService;



@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResouce {

    
    private static final Logger LOG = Logger.getLogger(EstadoResouce.class);

    @Inject
    private EstadoRepository repository;

    @Inject
    private EstadoService service;

    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin"})
    public List<EstadosResponseDTO> getAll() {
        
        // seleciona todas as Estados do banco de dados
        LOG.info("buscnado todos os estados");
         return service.getAll();

    }

    @POST
    @Path("/insert/{estado}")
    @RolesAllowed({"Admin","User"})
    @Transactional
    public EstadosResponseDTO insert(EstadosDTO estado) {
        
        LOG.info("buscnado estado por id");
        return service.create(estado);
    }

    @PUT
    @Path("/update/{id}")
    @RolesAllowed({"Admin","User"})
    @Transactional
    public EstadosResponseDTO update(@PathParam("id") Long id, EstadosDTO estado) {

        LOG.info("atualizando o estado selecionado pelo id");
        return service.update(id, estado);
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @RolesAllowed({"Admin"})
    public void DeleteForId(@PathParam("Id") long id){
        
        LOG.info("selecionado o estado e apagando o cadastro");
        service.delete(id);
    }

    @GET
    @Path("/count")
    @RolesAllowed({"Admin"})
    public long count(){

        LOG.info("count");
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed({"Admin","User"})
    public Estados search(@PathParam("nome") String nome){

        LOG.info("procurando por nome do estado");
        return repository.findByNome(nome);
    }
}
