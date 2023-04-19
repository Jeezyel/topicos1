package br.unitins.resouser;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Estados;
import br.unitins.repository.EstadoRepository;
import br.unitins.repository.RoupasRepository;



@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResouser {
    @Inject
    private EstadoRepository repository;

    @GET
    public List<Estados> getAll() {
        
        // seleciona todas as Estados do banco de dados
         return RoupasRepository.findAll().list();

    }

    @POST
    @Transactional
    public Estados insert(Estados estado) {

        repository.persist(estado);

        return estado;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Estados update(@PathParam("id") Long id, Estados estado) {

        Estados entity = repository.findById(id);

         entity.setNome(estado.getNome());
         entity.setSigla(estado.getSigla());

        return entity;
    }

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<Estados> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
}
