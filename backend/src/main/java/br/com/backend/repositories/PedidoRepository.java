package br.com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.domains.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
