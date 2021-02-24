package br.com.backendspring.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backendspring.backend.domains.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
