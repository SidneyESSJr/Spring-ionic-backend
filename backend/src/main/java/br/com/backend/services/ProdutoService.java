package br.com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.backend.domains.Categoria;
import br.com.backend.domains.Produto;
import br.com.backend.domains.dto.ProdutoDTO;
import br.com.backend.repositories.CategoriaRepository;
import br.com.backend.repositories.ProdutoRepository;
import br.com.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<ProdutoDTO> search(String nome, List<Integer> ids, Integer page, Integer size, String direction, String properties) {
        PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), properties);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return produtoRepository.search(nome, categorias, pageRequest).map(p -> new ProdutoDTO(p));
    }
}
