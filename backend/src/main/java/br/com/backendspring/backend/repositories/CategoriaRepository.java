package br.com.backendspring.backend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.backendspring.backend.domains.Categoria;
import br.com.backendspring.backend.domains.projecoes.ProjecaoCategoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT id, nome FROM tb_categoria", nativeQuery = true)
    List<ProjecaoCategoria> findAllProjecaoCategoria();

    @Query(value = "SELECT id, nome FROM tb_categoria", nativeQuery = true)
    Page<ProjecaoCategoria> findAllProjecaoCategoria(PageRequest pageRequest);

}
