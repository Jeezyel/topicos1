package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {

    public List<Telefone> findByNumero( String numero ){

        return numero == null ? null: find("UPPER(numero) LIKE ?1 ", "%" + numero + "%").list();

    }
    
}
