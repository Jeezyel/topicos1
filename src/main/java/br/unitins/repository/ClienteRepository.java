package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class ClienteRepository implements PanacheRepository {

    public Cliente findByNome(String nome){
        if(nome == null){
            return null;
        }
        return (Cliente) find("nome",  nome  ).firstResult();
    }

    public List<Cliente> findByNomeList(String nome){
        if(nome == null){
            return null;
        }
        return find("UPPER(nome) LIKE ?1 ", "%"+ nome.toUpperCase() +"%").list();
    }
    
}
