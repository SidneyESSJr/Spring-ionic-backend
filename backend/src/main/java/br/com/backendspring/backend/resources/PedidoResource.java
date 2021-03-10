package br.com.backendspring.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backendspring.backend.domains.Pedido;
import br.com.backendspring.backend.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }
}
