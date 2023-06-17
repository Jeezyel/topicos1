package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.service.TelefoneService;


import org.jboss.logging.Logger;


import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.TelefoneResponseDTO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

//Resouce

@Path("/telefone")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TelefoneResouce {

    
    private static final Logger LOG = Logger.getLogger(TelefoneResouce.class);

    @Inject
    TelefoneService service;


    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin"})
    public List<TelefoneResponseDTO> getAll(){
        try {
            LOG.info("buscnado todos os telefones");
            return service.getAll();
        } catch (Exception e) {
            return null;
        }
        
    }

    @GET
    @Path("/searchForId/{Id}")
    @RolesAllowed({"Admin","User"})
    public TelefoneResponseDTO searchForId(@PathParam("Id") Long Id){

        
        LOG.info("buscnado telefone por id");
        return service.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @RolesAllowed({"Admin","User"})
    @Transactional
    public TelefoneResponseDTO insert(TelefoneDTO telefoneDTO) {
        
        LOG.info("criando telefone");
        return service.create(telefoneDTO);
    }
    // update
    @POST
    @Path("/update/{id}")
    @RolesAllowed({"Admin","User"})
    @Transactional
    public TelefoneResponseDTO update(@PathParam("id") Long id, TelefoneDTO telefoneDTO) {
        
        LOG.info("atualizando o telefone selecionado pelo id");
        return service.update(id , telefoneDTO);
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @RolesAllowed({"Admin"})
    public void DeleteForId(@PathParam("Id") long id){

        LOG.info("selecionado o telefone e apagando o cadastro");
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
    public List<TelefoneResponseDTO> searchForName(@PathParam("name") String name){

        LOG.info("procurando por nome do telefone");
        return service.findByNome(name);
    }
}
