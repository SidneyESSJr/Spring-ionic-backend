package br.com.backendspring.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.backendspring.backend.domains.Categoria;
import br.com.backendspring.backend.domains.Cidade;
import br.com.backendspring.backend.domains.Cliente;
import br.com.backendspring.backend.domains.Endereco;
import br.com.backendspring.backend.domains.Estado;
import br.com.backendspring.backend.domains.Produto;
import br.com.backendspring.backend.domains.enums.TipoCliente;
import br.com.backendspring.backend.repositories.CategoriaRepository;
import br.com.backendspring.backend.repositories.CidadeRepository;
import br.com.backendspring.backend.repositories.ClienteRepository;
import br.com.backendspring.backend.repositories.EnderecoRepository;
import br.com.backendspring.backend.repositories.EstadoRepository;
import br.com.backendspring.backend.repositories.ProdutoRepository;

@Configuration
public class Instanciando implements CommandLineRunner {

    @Autowired
    private CategoriaRepository catRepository;

    @Autowired
    private ProdutoRepository proRepository;

    @Autowired
    private EstadoRepository estRepository;

    @Autowired
    private CidadeRepository cidRepository;

    @Autowired
    private ClienteRepository cliRepository;

    @Autowired
    private EnderecoRepository endRepository;

    @Override
    public void run(String... args) throws Exception {

        catRepository.deleteAll();
        proRepository.deleteAll();
        cidRepository.deleteAll();
        estRepository.deleteAll();
        cliRepository.deleteAll();
        endRepository.deleteAll();

        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");

        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);

        catRepository.saveAll(Arrays.asList(cat1, cat2));
        proRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado("Minas Gerais");
        Estado est2 = new Estado("São Paulo");

        Cidade c1 = new Cidade("Uberlândia", est1);
        Cidade c2 = new Cidade("São Paulo", est2);
        Cidade c3 = new Cidade("Campinas", est2);

        estRepository.saveAll(Arrays.asList(est1, est2));
        cidRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("28363323", "93898993"));

        Endereco e1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardin", "38220834", cli1, c1);
        Endereco e2 = new Endereco("Avenida Matos", "102", "Sala 800", "Centro", "38777012", cli1, c2);

        cliRepository.save(cli1);
        endRepository.saveAll(Arrays.asList(e1, e2));

    }

}
