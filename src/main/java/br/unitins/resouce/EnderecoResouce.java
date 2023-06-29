package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.service.ClienteService;
import br.unitins.service.EnderecoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.EnderecoResponseDTO;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResouce {

    
    private static final Logger LOG = Logger.getLogger(EnderecoResouce.class);

    @Inject
    private EnderecoService service;

    @Inject
    JsonWebToken tokenJwt;

    @Inject
    ClienteService clienteService;


    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin"})
    public List<EnderecoResponseDTO> getAll(){
        LOG.info("buscnado todos os enderecos");
        return service.getAll();
    }

    @GET
    @Path("/searchForId/{Id}")
    @RolesAllowed({"Admin"})
    public EnderecoResponseDTO searchForId(@PathParam("Id") Long Id){

        LOG.info("buscnado endereco por id");
        return service.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @RolesAllowed({"Admin","User", "Cliente"})
    @Transactional
    public EnderecoResponseDTO insert(EnderecoDTO enderecoDTO) {
        
        LOG.info("criando endereco");
        return service.create(enderecoDTO);
    }
    // update
    @POST
    @Path("/update/{id}")
    @RolesAllowed({"Admin"})
    @Transactional
    public EnderecoResponseDTO updateEndereco(@PathParam("id") Long id, EnderecoDTO enderecoDTO) {
        
        LOG.info("atualizando o endereco selecionado pelo id");
        return service.update(id , enderecoDTO);
    }

    // update
    @POST
    @Path("/update do usuario")
    @RolesAllowed({"Admin" , "User", "Cliente"})
    @Transactional
    public EnderecoResponseDTO updateEnderecoUsuarioLogado( EnderecoDTO enderecoDTO) {
        
        String login = tokenJwt.getSubject();

        LOG.info("atualizando o endereco selecionado pelo id");
        return service.update( clienteService.findByLogin(login).getId() , enderecoDTO);
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @RolesAllowed({"Admin"})
    public void DeleteForId(@PathParam("Id") long id){

        
        LOG.info("selecionado o endereco e apagando o cadastro");
        service.delete(id);
    }

    @DELETE
    @Path("/DeleteForUserLogin")
    @RolesAllowed({"Admin" , "User", "Cliente"})
    public void DeleteForUserLogin(){

        String login = tokenJwt.getSubject();
        
        LOG.info("selecionado o endereco e apagando o cadastro");
        service.delete(login);
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
    @RolesAllowed({"Admin" , "User", "Cliente"})
    public List<EnderecoResponseDTO> searchForName(@PathParam("name") String name){
        LOG.info("procurando por nome do endereco");
        return service.findByNome(name);
    }
}
