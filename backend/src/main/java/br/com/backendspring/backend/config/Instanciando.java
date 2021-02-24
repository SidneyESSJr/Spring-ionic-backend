package br.com.backendspring.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.backendspring.backend.domain.Categoria;
import br.com.backendspring.backend.domain.Produto;
import br.com.backendspring.backend.repository.CategoriaRepository;
import br.com.backendspring.backend.repository.ProdutoRepository;

@Configuration
public class Instanciando implements CommandLineRunner {

    @Autowired
    private CategoriaRepository cRepository;

    @Autowired
    private ProdutoRepository pRepository;

    @Override
    public void run(String... args) throws Exception {

        cRepository.deleteAll();
        pRepository.deleteAll();

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        // cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        // cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        cRepository.saveAll(Arrays.asList(cat1, cat2));
        pRepository.saveAll(Arrays.asList(p1, p2, p3));

    }

}
