package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.service.ClienteService;
import br.unitins.service.TelefoneService;

import org.eclipse.microprofile.jwt.JsonWebToken;
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
    TelefoneService telefoneservice;

    @Inject
    ClienteService clienteService;

    @Inject
    JsonWebToken tokenJwt;


    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin"})
    public TelefoneResponseDTO getAll(){
        try {
            LOG.info("buscnado todos os telefones");
            return telefoneservice.getTelefone();
        } catch (Exception e) {
            return null;
        }
        
    }

     @GET
    @Path("/get-all-usuario-logado")
    @RolesAllowed({"Admin"})
    public List<TelefoneResponseDTO> getAllUsuarioLogado(){

        
        try {
            
            LOG.info("buscnado o telefones");
            return telefoneservice.getAll();
        } catch (Exception e) {
            return null;
        }
        
    }

    @GET
    @Path("/searchForId/{Id}")
    @RolesAllowed({"Admin"})
    public TelefoneResponseDTO searchForId(@PathParam("Id") Long Id){

        
        LOG.info("buscnado telefone por id");
        return telefoneservice.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @RolesAllowed({"Admin","User"})
    @Transactional
    public TelefoneResponseDTO insert(TelefoneDTO telefoneDTO) {
        
        LOG.info("criando telefone");
        return telefoneservice.create(telefoneDTO);
    }
    // update
    @POST
    @Path("/update/{id}")
    @RolesAllowed({"Admin","User"})
    @Transactional
    public TelefoneResponseDTO update(@PathParam("id") Long id, TelefoneDTO telefoneDTO) {
        
        LOG.info("atualizando o telefone selecionado pelo id");
        return telefoneservice.update(id , telefoneDTO);
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @RolesAllowed({"Admin"})
    public void DeleteForId(@PathParam("Id") long id){

        LOG.info("selecionado o telefone e apagando o cadastro");
        telefoneservice.delete(id);
    }

    @GET
    @Path("/count")
    @RolesAllowed({"Admin"})
    public long count(){
        
        LOG.info("count");
        return telefoneservice.count();
    }

    @GET
    @Path("/searchForName/{name}")
    @RolesAllowed({"Admin","User"})
    public List<TelefoneResponseDTO> searchForName(@PathParam("name") String name){

        LOG.info("procurando por nome do telefone");
        return telefoneservice.findByNome(name);
    }
}
