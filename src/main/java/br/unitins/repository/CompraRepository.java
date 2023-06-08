package br.unitins.repository;


import br.unitins.model.Compra;
import br.unitins.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraRepository implements PanacheRepository<Compra>{
    
    public Compra findByID(Long id ){
        return findById(id);  
    }

    public Compra findByEndereco(Endereco endereco ){
        return find("UPPER(endereco) LIKE ?1 ", "%"+ endereco +"%").firstResult(); 
    }
}
