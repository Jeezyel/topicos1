package br.unitins.repository;

import java.util.List;

import br.unitins.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{

    public List<Usuario> findByNomeList(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").list();
    }

    public List<Usuario> findByNome(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").firstResult();
    }
    
    public List<Usuario> deleteForLogin(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").firstResult();
    }
}
