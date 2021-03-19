package br.com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.domains.ItemPedido;
import br.com.backend.domains.pkcomposta.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
