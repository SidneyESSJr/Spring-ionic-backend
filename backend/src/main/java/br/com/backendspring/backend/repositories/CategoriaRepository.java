package br.com.backendspring.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.backendspring.backend.domains.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
