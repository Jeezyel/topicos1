package br.unitins.repository;

import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.model.Comprovante;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class ComprovanteRepository implements PanacheRepository<Comprovante> {

    public Comprovante findByID(Long id ){
        return findById(id);  
    }
    
}
