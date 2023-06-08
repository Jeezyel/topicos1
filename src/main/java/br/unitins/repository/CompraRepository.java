package br.unitins.repository;


import java.util.List;

import br.unitins.model.Cliente;
import br.unitins.model.Compra;
import br.unitins.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraRepository implements PanacheRepository<Compra>{
    
    public Compra findByID(Long id ){
        return findById(id);  
    }
    public List<Compra> findByClientelist(Cliente cliente){

        return find("UPPER(cliente) LIKE ?1 ", "%"+ cliente +"%").list();
    }

    public Compra findByCliente(Cliente cliente){

        return find("UPPER(cliente) LIKE ?1 ", "%"+ cliente +"%").firstResult();
    }

    public Compra findByEndereco(Endereco endereco ){

        return find("UPPER(endereco) LIKE ?1 ", "%"+ endereco +"%").firstResult(); 
    }
}
