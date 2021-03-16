package br.com.backendspring.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.backendspring.backend.domains.Categoria;
import br.com.backendspring.backend.domains.projecoes.ProjecaoCategoria;
import br.com.backendspring.backend.repositories.CategoriaRepository;
import br.com.backendspring.backend.services.exceptions.DataIntegrityException;
import br.com.backendspring.backend.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<ProjecaoCategoria> findAll() {
        return repository.findAllProjecaoCategoria();
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        return repository.save(categoria);
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
