package br.unitins.resouce;

import jakarta.ws.rs.Produces;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


import org.jboss.logging.Logger;

import br.unitins.aplication.Result;
import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResponseDTO;
import br.unitins.repository.RoupasRepository;
import br.unitins.service.RoupaService;

import java.util.List;

@Path("/roupa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoupasResouce  {

    
    private static final Logger LOG = Logger.getLogger(RoupasResouce.class);

    @Inject
    RoupasRepository roupasRepository;

    @Inject
    RoupaService roupaServicempl;

    // buscar tudo
    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin","User"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoupasResponseDTO> getAll(){

        LOG.info("buscnado todas as roupas");
        return roupaServicempl.getAll();

    }


    //alterar 
    @PATCH
    @Path("/update/{ID}")
    @RolesAllowed({"Admin"})
    @Transactional
    public RoupasResponseDTO update (@PathParam("/ID") Long ID , RoupasDTO roupas ){

        
        LOG.info("atualizando a roupa selecionado pelo id");
        RoupasResponseDTO roupasDTO ;

        if(ID == null){
            return null;
        }

        roupasDTO = roupaServicempl.update(ID, roupas);

        return roupasDTO ;
    }
    //deletar por id
    @DELETE
    @Path("/deleteRoupas/{ID}")
    @RolesAllowed({"Admin"})
    @Transactional
    public void deleteRoupas(@PathParam("ID") Long ID ){

        LOG.info("selecionado a roupa e apagando o cadastro");
        roupaServicempl.delete(ID);

    }

    //deletar por fragmento da marca retornando um resultado 
    @GET
    @Path("/searchForName/{nameMarca}")
    @RolesAllowed({"Admin"})
    public RoupasResponseDTO searchForName(@PathParam("nameMarca") String nameMarca){

        LOG.info("selecionado a roupa e apagando o cadastro usando palavra fragmentada");
        return nameMarca == null ? null : roupaServicempl.findByName(nameMarca); 

    }
    //deletar por marca
    @DELETE
    @Path("/DeletForName/{nameMarca}")
    @RolesAllowed({"Admin"})
    @Transactional
    public void DeletForName(@PathParam("nameMarca") String nameMarca ){
        LOG.info("apagando pelo nome inteiro");
        roupaServicempl.findByName(nameMarca);
        
    }
    //alterar so que usando outro metodo de escrida 
    @PUT
    @Path("/alter/{id}")
    @RolesAllowed({"Admin"})
    public RoupasResponseDTO alterRoupas(@PathParam("id")Long id , RoupasDTO roupas){

        LOG.info("alterar so que usando outro metodo de escrida");
        return id == null || roupas == null ? null : roupaServicempl.update(id, roupas);

    }
    //procurar por fragmento da marca retornando um lista de resultado 
    @GET
    @Path("/searchForFragmento/{fragmentoMarca}")
    @RolesAllowed({"Admin"})
    public List<RoupasResponseDTO> searchForFragmento(@PathParam("fragmentoMarca") String fragmentoMarca){

        LOG.info("buscando pro fragmento");
        return roupaServicempl.findByNameList(fragmentoMarca);
    } 

    @GET
    @Path("/count")
    @RolesAllowed({"Admin"})
    public long count(){
        
        LOG.info("count");
        return roupaServicempl.count();
    }

    //criar
    @POST
    @Path("/insert")
    @RolesAllowed({"Admin"})
    @Transactional
    public Response insert(RoupasDTO dto){
        
        LOG.info("criando roupas");
        try {
            LOG.info("criando roupas");
            RoupasResponseDTO roupas = roupaServicempl.create(dto); 
            return Response.status(Status.CREATED).entity(roupas).build();
            
        } catch (ConstraintViolationException e) {
            LOG.info("erro de ConstraintViolationException ");
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        } catch(Exception e){
            
            LOG.fatal("erro não listado, fatal");
            
            Result result = new Result(e.getMessage());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
        
    }
}
