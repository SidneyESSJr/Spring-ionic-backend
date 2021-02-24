package br.com.backendspring.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backendspring.backend.domain.Categoria;
import br.com.backendspring.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Categoria insert(Categoria obj) {
        return repository.save(obj);
    }

    // public Categoria update(Categoria obj) {

    // }
}
