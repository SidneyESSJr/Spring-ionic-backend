package br.com.backendspring.backend.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backendspring.backend.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @GetMapping
    public ResponseEntity<Categoria> test() {
        return ResponseEntity.ok().body(new Categoria(1, "informática"));
    }

}
