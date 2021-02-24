package br.com.backendspring.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.backendspring.backend.domains.Categoria;
import br.com.backendspring.backend.domains.Cidade;
import br.com.backendspring.backend.domains.Estado;
import br.com.backendspring.backend.domains.Produto;
import br.com.backendspring.backend.repositories.CategoriaRepository;
import br.com.backendspring.backend.repositories.CidadeRepository;
import br.com.backendspring.backend.repositories.EstadoRepository;
import br.com.backendspring.backend.repositories.ProdutoRepository;

@Configuration
public class Instanciando implements CommandLineRunner {

    @Autowired
    private CategoriaRepository cRepository;

    @Autowired
    private ProdutoRepository pRepository;

    @Autowired
    private EstadoRepository eRepository;

    @Autowired
    private CidadeRepository cidRepository;

    @Override
    public void run(String... args) throws Exception {

        cRepository.deleteAll();
        pRepository.deleteAll();
        cidRepository.deleteAll();
        eRepository.deleteAll();

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        eRepository.saveAll(Arrays.asList(est1, est2));
        cidRepository.saveAll(Arrays.asList(c1, c2, c3));
        cRepository.saveAll(Arrays.asList(cat1, cat2));
        pRepository.saveAll(Arrays.asList(p1, p2, p3));

    }

}
