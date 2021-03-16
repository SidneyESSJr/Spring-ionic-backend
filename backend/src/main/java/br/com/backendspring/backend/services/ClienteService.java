package br.com.backendspring.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.backendspring.backend.domains.Cliente;
import br.com.backendspring.backend.repositories.ClienteRepository;
import br.com.backendspring.backend.services.exceptions.DataIntegrityException;
import br.com.backendspring.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        findById(cliente.getId());
        return repository.save(cliente);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel remover uma Categoria com produtos vinculados a ela");
        }
    }

}
