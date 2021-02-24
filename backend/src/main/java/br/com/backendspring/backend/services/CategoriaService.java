package br.com.backendspring.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backendspring.backend.domains.Categoria;
import br.com.backendspring.backend.repositories.CategoriaRepository;
import br.com.backendspring.backend.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "O objeto não encotrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        return repository.save(obj);
    }

    // public Categoria update(Categoria obj) {

    // }
}
