package br.com.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.backend.domains.Categoria;
import br.com.backend.domains.dto.CategoriaDTO;
import br.com.backend.repositories.CategoriaRepository;
import br.com.backend.services.exceptions.DataIntegrityException;
import br.com.backend.services.exceptions.ObjectNotFoundException;

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
        List<CategoriaDTO> list = repository.findAll().stream().map(f -> new CategoriaDTO(f))
                .collect(Collectors.toList());
        return list;
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(CategoriaDTO categoriaDTO) {
        Categoria categoria = findById(categoriaDTO.getId());
        updateData(categoriaDTO, categoria);
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
        return repository.findAll(pageRequest).map(f -> new CategoriaDTO(f));
    }

    private void updateData(CategoriaDTO categoriaDTO, Categoria categoria) {
        categoria.setNome(categoriaDTO.getNome());
    }
}
