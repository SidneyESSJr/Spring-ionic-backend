package br.com.backendspring.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.backendspring.backend.domains.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}