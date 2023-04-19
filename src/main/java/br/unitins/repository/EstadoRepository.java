package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Estados;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
    public class EstadoRepository implements PanacheRepository<Estados> {
    
    public List<Estados> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
