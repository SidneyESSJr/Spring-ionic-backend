package br.com.backendspring.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.backendspring.backend.domains.Categoria;
import br.com.backendspring.backend.domains.dto.CategoriaDTO;
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

    public List<CategoriaDTO> findAll() {
        List<CategoriaDTO> list = repository.findAll().stream().map(f -> toCategoria(f)).collect(Collectors.toList());
        return list;
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

    public Page<CategoriaDTO> findPage(Integer page, Integer size, String direction, String properties) {
        PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), properties);
        return repository.findAll(pageRequest).map(f -> toCategoria(f));
    }

    public CategoriaDTO toCategoria(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

    public Categoria fromDTO(CategoriaDTO dto) {
        return new Categoria(dto.getId(), dto.getNome());
    }
}
