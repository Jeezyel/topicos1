package br.unitins.resouser;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResouserDTO;
import br.unitins.model.Roupas;
import br.unitins.repository.RoupasRepository;
import br.unitins.service.RoupaServicempl;

import java.util.List;
import java.util.stream.Collector;

@Path("/Loja")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoupasResouser {

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
    //alterar cor e marca 
    @PATCH
    @Path("/{ID}")
    @Transactional
    public Roupas att (@PathParam("/ID") Long ID , Roupas roupas ){
        Roupas r2 = roupasRepository.findById(ID);
        r2.setCor(roupas.getCor());
        r2.setMarca(roupas.getMarca());

        return r2;
    }
    //deletar por id
    @DELETE
    @Path("/{ID}")
    @Transactional
    public Roupas deleteRoupas(@PathParam("ID") Long ID , Roupas roupas){
        Roupas r2 = roupasRepository.findById(ID);

        roupasRepository.delete(r2);

        return r2;

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
    public Roupas DeletForName(@PathParam("nameMarca") String nameMarca ){
        Roupas roupaForDelet = roupasRepository.findByMarca(nameMarca);
        roupasRepository.delete(roupaForDelet);
        return roupaForDelet;
    }
    //alterar tudo
    @PUT
    @Path("/{id}")
    public Roupas alterRoupas(@PathParam("id")Long id , Roupas roupas){

        Roupas newRoupa = roupasRepository.findById(id);
        newRoupa.setQuantidade(roupas.getQuantidade());
        newRoupa.setValor(roupas.getValor());
        newRoupa.setCor(roupas.getCor());
        newRoupa.setTipoDeTercido(roupas.getTipoDeTercido());
        newRoupa.setMarca(roupas.getMarca());
        newRoupa.setModelo(roupas.getModelo());

        return newRoupa;

    }
    //deletar por fragmento da marca retornando um lista de resultado 
    @GET
    @Path("/{fragmentoMarca}")
    public List<Roupas> searchForFragmento(@PathParam("fragmentoMarca") String fragmentoMarca){


        return roupasRepository.findByMarcaList(fragmentoMarca);
    } 
    //criar
    public Response insert(RoupasDTO dto){
        Roupas entity = new Roupas();
        entity.setValor(dto.getValor());
        entity.setCor(dto.getCor());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());

        roupasRepository.persist(entity);

        return Response.status(Status.CREATED).entity(new RoupasResouserDTO(entity)).build();
    }
}
