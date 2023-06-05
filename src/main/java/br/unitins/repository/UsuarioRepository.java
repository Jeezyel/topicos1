package br.unitins.repository;

import java.util.List;

import br.unitins.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Cliente>{

    public List<Cliente> findByNomeList(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").list();
    }

    public List<Cliente> findByLogin(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").firstResult();
    }
    
    public List<Cliente> deleteForLogin(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").firstResult();
    }
}
