package br.com.backendspring.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backendspring.backend.domains.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
