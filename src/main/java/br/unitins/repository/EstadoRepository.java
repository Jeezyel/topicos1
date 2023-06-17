package br.unitins.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import br.unitins.model.Estados;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
    public class EstadoRepository implements PanacheRepository<Estados> {
    
    public List<Estados> findByListaNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
    public Estados findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").firstResult();
    }
}
