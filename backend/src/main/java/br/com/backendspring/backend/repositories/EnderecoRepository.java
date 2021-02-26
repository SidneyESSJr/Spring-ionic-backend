package br.com.backendspring.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backendspring.backend.domains.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
