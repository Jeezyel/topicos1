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
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login +"%").firstResult();
    }

    public List<Cliente> findByLoginList(String Login){
        if(Login == null){
            return null;
        }
        return find("UPPER(Login) LIKE ?1 ", "%"+ Login.toUpperCase() +"%").list();
    }
    
    public Cliente findByLoginAndSenha(String login, String senha) {

        if (login == null || senha == null)
            return null;

        return find("login = ?1 AND senha = ?2 ", login, senha).firstResult();
    }
    
}
