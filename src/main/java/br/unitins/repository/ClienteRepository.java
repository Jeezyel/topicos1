package br.unitins.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import br.unitins.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public Cliente findByNome(String nome){
        if(nome == null){
            return null;
        }
        return (Cliente) find("nome",  nome  ).firstResult();
    }

    public Cliente findByLogin(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").firstResult();
    }
    

    public List<Cliente> findByNomeList(String nome){
        if(nome == null){
            return null;
        }
        return find("UPPER(nome) LIKE ?1 ", "%"+ nome.toUpperCase() +"%").list();
    }
    
}
