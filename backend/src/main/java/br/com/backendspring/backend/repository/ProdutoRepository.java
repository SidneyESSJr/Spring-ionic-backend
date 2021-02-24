package br.com.backendspring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backendspring.backend.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
