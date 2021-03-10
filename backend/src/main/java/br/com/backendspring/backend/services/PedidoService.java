package br.com.backendspring.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backendspring.backend.domains.Pedido;
import br.com.backendspring.backend.repositories.PedidoRepository;
import br.com.backendspring.backend.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido findById(Integer id) {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
