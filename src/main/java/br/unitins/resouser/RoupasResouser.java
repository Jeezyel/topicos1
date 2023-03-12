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

import br.unitins.dto.RoupasResouserDTO;
import br.unitins.model.Roupas;
import br.unitins.repository.RoupasRepository;

import java.util.List;
import java.util.stream.Collector;

@Path("/Loja")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoupasResouser {

    @Inject
    RoupasRepository roupasRepository;

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roupas> getAll(){

        return roupasRepository.findAll().stream().map(roupas -> new RoupasResouserDTO(roupas)).collect(Collector.toList());

    }

    @POST
    @Transactional
    public Roupas addList(Roupas roupas){
        roupas.persist();

        return roupas;

    }

    @PATCH
    @Path("/{ID}")
    @Transactional
    public Roupas att (@PathParam("/ID") Long ID , Roupas roupas ){
        Roupas r2 = roupasRepository.findById(ID);
        r2.setCor(roupas.getCor());
        r2.setMarca(roupas.getMarca());

        return r2;
    }

    @DELETE
    @Path("/{ID}")
    @Transactional
    public Roupas deleteRoupas(@PathParam("ID") Long ID , Roupas roupas){
        Roupas r2 = roupasRepository.findById(ID);

        r2.delete();

        return r2;

    }

    
    @GET
    @Path("/{nameMarca}")
    public Roupas searchForName(@PathParam("nameMarca") String nameMarca){

        Roupas roupaForSearch = (Roupas) roupasRepository.findByMarca(nameMarca);
        roupasRepository.delete(roupaForSearch);
        return roupaForSearch;

    }

    @DELETE
    @Path("/{nameMarca}")
    @Transactional
    public Roupas DeletForName(@PathParam("nameMarca") String nameMarca ){
        Roupas roupaForDelet = roupasRepository.findByMarca(nameMarca);
        roupasRepository.delete(roupaForDelet);
        return roupaForDelet;
    }

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
    @GET
    @Path("/{fragmentoMarca}")
    public List<Roupas> searchForFragmento(@PathParam("fragmentoMarca") String fragmentoMarca){


        return roupasRepository.findByMarcaList(fragmentoMarca);
    } 
}
