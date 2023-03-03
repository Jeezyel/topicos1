package br.unitins.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import br.unitins.model.Roupas;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class RoupasRepository implements PanacheRepository<Roupas> {

    public Roupas findByMarca(String marca ){
        return find("marca", "%" + marca +"%" ).firstResult();   
    }

    public Roupas findByMarca(Long marca ){
        return find("marca", "%" + marca +"%" ).firstResult();   
    }

    public List<Roupas> findeByName(String name){
        String searchTerm = "%" + name + "%";
        String query = "SELECT * FROM roupas WHERE nome LIKE ?";
        ArrayList listInRoupas =  null;

        return listInRoupas ;
    }

    //ajustar pra retorne uma lista 

 /*   @PersistenceContext
    EntityManager em;

    public List<Livraria> findByName(String nomeLivroString) {
        return em.createQuery("FROM Livraria l WHERE l.nomeLivro LIKE CONCAT('%', :nomeLivro, '%')", Livraria.class)
                 .setParameter("nomeLivro", nomeLivroString)
                 .getResultList();
    } */



  /*  public String like(String str, String expr) {
        expr = expr.toLowerCase();
        expr = expr.replace(".", "\."); // "\" is escaped to "" (thanks, Alan M)
        // ... escape any other potentially problematic characters here
        expr = expr.replace("?", ".");
        expr = expr.replace("%", ".*");
        str = str.toLowerCase();
        return str.matches(expr);
    }*/ 

}


