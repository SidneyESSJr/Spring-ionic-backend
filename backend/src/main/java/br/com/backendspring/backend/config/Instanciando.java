package br.com.backendspring.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.backendspring.backend.domain.Categoria;
import br.com.backendspring.backend.repository.CategoriaRepository;

@Configuration
public class Instanciando implements CommandLineRunner {

    @Autowired
    private CategoriaRepository cRepository;

    @Override
    public void run(String... args) throws Exception {

        cRepository.deleteAll();

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        cRepository.saveAll(Arrays.asList(cat1, cat2));

    }

}
