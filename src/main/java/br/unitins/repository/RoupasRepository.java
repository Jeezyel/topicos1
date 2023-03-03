package br.unitins.repository;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Roupas;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class RoupasRepository implements PanacheRepository<Roupas> {

    public Roupas findByMarca(String marca ){
        return find("marca", marca ).firstResult();   
    }
}
