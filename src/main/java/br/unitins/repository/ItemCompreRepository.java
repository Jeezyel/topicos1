package br.unitins.repository;

import java.util.List;

import br.unitins.model.ItemCompra;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemCompreRepository implements PanacheRepository<ItemCompra> {
    
    public List<ItemCompra> findByNome(Double valor){
        if (valor == null)
            return null;
        return find("UPPER(valor) LIKE ?1 ", "%"+valor+"%").list();
    }
}
