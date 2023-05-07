package br.unitins.repository;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped; 
import br.unitins.model.Roupas;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class RoupasRepository implements PanacheRepository<Roupas> {

    public Roupas findByMarca(String marca ){
        return find("marca",  marca  ).firstResult();   
    }

    public List<Roupas> findByMarcaList(String marca) {
        if(marca == null){
            return null;
        }
        return find("UPPER(marca) LIKE ?1 ", "%" + marca.toUpperCase() + "%").list();
    }
    public Roupas findByID(Long id ){
        return findById(id);  
    }
}


