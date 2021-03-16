package br.com.backendspring.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.backendspring.backend.domains.Categoria;
import br.com.backendspring.backend.domains.projecoes.ProjecaoCategoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT c.id, c.nome FROM tb_categoria c", nativeQuery = true)
    List<ProjecaoCategoria> findAllProjecaoCategoria();

}
