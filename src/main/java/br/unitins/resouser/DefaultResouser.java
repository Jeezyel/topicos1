package br.unitins.resouser;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResouserDTO;

public interface DefaultResouser {
     // buscar tudo
     public List<RoupasResouserDTO> getAll();
 /* 
     @POST
     @Transactional
     public Roupas addList(Roupas roupas){
         roupas.persist();
 
         return roupas;
 
     }
 */
     //alterar 
     public RoupasResouserDTO att (@PathParam("/ID") Long ID , RoupasDTO roupas );
     //deletar por id
     public void deleteRoupas(@PathParam("ID") Long ID );
 
     //deletar por fragmento da marca retornando um resultado
     public RoupasResouserDTO searchForName(@PathParam("nameMarca") String nameMarca);
     //deletar por marcaa") String nameMarca )
     public RoupasResouserDTO alterRoupas(@PathParam("id")Long id , RoupasDTO roupas);
     //procurar por fragmento da marca retornando um lista de resultado 
     public List<RoupasResouserDTO> searchForFragmento(@PathParam("fragmentoMarca") String fragmentoMarca);
     //criar
     public Response insert(RoupasDTO dto);
}
