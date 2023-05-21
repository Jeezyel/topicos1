package br.unitins.resouce;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.unitins.aplication.Result;
import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResponseDTO;
import br.unitins.repository.RoupasRepository;
import br.unitins.service.RoupaService;

import java.util.List;

@Path("/Loja")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoupasResouce  {

    @Inject
    RoupasRepository roupasRepository;

    @Inject
    RoupaService roupaServicempl;

    // buscar tudo
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoupasResponseDTO> getAll(){

        return roupaServicempl.getAll();

    }
/* 
    @POST
    @Transactional
    public Roupas addList(Roupas roupas){
        roupas.persist();

        return roupas;

    }
*/
    //alterar 
    @PATCH
    @Path("/{ID}")
    @Transactional
    public RoupasResponseDTO att (@PathParam("/ID") Long ID , RoupasDTO roupas ){
        RoupasResponseDTO roupasDTO ;

        if(ID == null){
            return null;
        }

        roupasDTO = roupaServicempl.updata(ID, roupas);

        return roupasDTO ;
    }
    //deletar por id
    @DELETE
    @Path("/{ID}")
    @Transactional
    public void deleteRoupas(@PathParam("ID") Long ID ){

        roupaServicempl.delete(ID);

    }

    //deletar por fragmento da marca retornando um resultado 
    @GET
    @Path("/{nameMarca}")
    public RoupasResponseDTO searchForName(@PathParam("nameMarca") String nameMarca){

        
        return nameMarca == null ? null : roupaServicempl.findByName(nameMarca); 

    }
    //deletar por marca
    @DELETE
    @Path("/{nameMarca}")
    @Transactional
    public void DeletForName(@PathParam("nameMarca") String nameMarca ){
        roupaServicempl.findByName(nameMarca);
        
    }
    //alterar tudo
    @PUT
    @Path("/{id}")
    public RoupasResponseDTO alterRoupas(@PathParam("id")Long id , RoupasDTO roupas){


        return id == null || roupas == null ? null : roupaServicempl.updata(id, roupas);

    }
    //procurar por fragmento da marca retornando um lista de resultado 
    @GET
    @Path("/{fragmentoMarca}")
    public List<RoupasResponseDTO> searchForFragmento(@PathParam("fragmentoMarca") String fragmentoMarca){


        return roupaServicempl.findByNameList(fragmentoMarca);
    } 

    @GET
    @Path("/count")
    public long count(){
        return roupaServicempl.count();
    }

    //criar
    public Response insert(RoupasDTO dto){
        try {
            RoupasResponseDTO roupas = roupaServicempl.create(dto); 
            return Response.status(Status.CREATED).entity(roupas).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
        
    }
}
