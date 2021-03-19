package br.com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.domains.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
