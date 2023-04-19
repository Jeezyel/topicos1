package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

    public List<Endereco> findByNumero( String cep ){

        return cep == null ? null : find("UPPER(cep) LIKE ?1 ", "%" + cep + "%").list();

    }
    
}
