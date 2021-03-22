package br.com.backend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.backend.domains.Categoria;
import br.com.backend.domains.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    // Metodo para consulta de produtos por parte do nome e pelas categorias
    // relacionadas a ele
    @Transactional(readOnly = true) // query somente para leitura (desempenho)
    @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
    Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias,
            Pageable pageRequest);

    // Mesma consulta realizada acima, porem com query methods
    @Transactional(readOnly = true) // query somente para leitura (desempenho)
    Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias,
            Pageable pageRequest);

}
