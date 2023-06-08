package br.unitins.repository;

import br.unitins.model.Compra;
import br.unitins.model.Pagamento;
import br.unitins.model.TipoPagamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoRepository implements PanacheRepository<Pagamento> {
    public Pagamento findByCompra(Compra compra){
        if(compra == null){
            return null;
        }
        return  find("UPPER(compra) LIKE ?1 ", "%"+ compra +"%").firstResult();
    }

    public Pagamento findByTipoPagamento(TipoPagamento tipoPagamento){
        if(tipoPagamento == null){
            return null;
        }
        return  find("UPPER(tipoPagamento) LIKE ?1 ", "%"+ tipoPagamento +"%").firstResult();
    }

    
}
