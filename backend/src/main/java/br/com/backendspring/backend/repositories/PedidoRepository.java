package br.com.backendspring.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backendspring.backend.domains.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
