package br.unitins.resouser;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unitins.aplication.Result;
import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResouserDTO;
import br.unitins.model.Roupas;
import br.unitins.repository.RoupasRepository;
import br.unitins.service.RoupaServicempl;

import java.util.List;

@Path("/Loja")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoupasResouser  {

    @Inject
    RoupasRepository roupasRepository;

    @Inject
    RoupaServicempl roupaServicempl;

    // buscar tudo
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoupasResouserDTO> getAll(){

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
    public RoupasResouserDTO att (@PathParam("/ID") Long ID , RoupasDTO roupas ){
        RoupasResouserDTO roupasDTO ;

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
    public Roupas searchForName(@PathParam("nameMarca") String nameMarca){

        Roupas roupaForSearch = (Roupas) roupasRepository.findByMarca(nameMarca);
        roupasRepository.delete(roupaForSearch);
        return roupaForSearch;

    }
    //deletar por marca
    @DELETE
    @Path("/{nameMarca}")
    @Transactional
    public void DeletForName(@PathParam("nameMarca") String nameMarca ){
        Roupas roupaForDelet = roupasRepository.findByMarca(nameMarca);
        roupaServicempl.delete(roupaForDelet.getId());
        
    }
    //alterar tudo
    @PUT
    @Path("/{id}")
    public RoupasResouserDTO alterRoupas(@PathParam("id")Long id , RoupasDTO roupas){


        return id == null || roupas == null ? null : roupaServicempl.updata(id, roupas);

    }
    //deletar por fragmento da marca retornando um lista de resultado 
    @GET
    @Path("/{fragmentoMarca}")
    public List<Roupas> searchForFragmento(@PathParam("fragmentoMarca") String fragmentoMarca){


        return roupasRepository.findByMarcaList(fragmentoMarca);
    } 
    //criar
    public Response insert(RoupasDTO dto){
        try {
            RoupasResouserDTO roupas = roupaServicempl.create(dto); 
            return Response.status(Status.CREATED).entity(roupas).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
        
    }
}
