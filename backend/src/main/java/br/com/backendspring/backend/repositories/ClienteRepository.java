package br.com.backendspring.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backendspring.backend.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
