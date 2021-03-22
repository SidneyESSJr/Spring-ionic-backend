package br.com.backend.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.backend.domains.Categoria;
import br.com.backend.domains.Cidade;
import br.com.backend.domains.Cliente;
import br.com.backend.domains.Endereco;
import br.com.backend.domains.Estado;
import br.com.backend.domains.ItemPedido;
import br.com.backend.domains.Pagamento;
import br.com.backend.domains.PagamentoComBoleto;
import br.com.backend.domains.PagamentoComCartao;
import br.com.backend.domains.Pedido;
import br.com.backend.domains.Produto;
import br.com.backend.domains.enums.EstadoPagamento;
import br.com.backend.domains.enums.TipoCliente;
import br.com.backend.repositories.CategoriaRepository;
import br.com.backend.repositories.CidadeRepository;
import br.com.backend.repositories.ClienteRepository;
import br.com.backend.repositories.EnderecoRepository;
import br.com.backend.repositories.EstadoRepository;
import br.com.backend.repositories.ItemPedidoRepository;
import br.com.backend.repositories.PagamentoRepository;
import br.com.backend.repositories.PedidoRepository;
import br.com.backend.repositories.ProdutoRepository;

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

    @Autowired
    private PedidoRepository pedRepository;

    @Autowired
    private PagamentoRepository pagRepository;

    @Autowired
    private ItemPedidoRepository ipRepository;

    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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
        Categoria cat3 = new Categoria("Elétrodomesticos");
        Categoria cat4 = new Categoria("Eletronicos");
        Categoria cat5 = new Categoria("Perfumaria");
        Categoria cat6 = new Categoria("Veicular");
        Categoria cat7 = new Categoria("Cama mesa e banho");

        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);
        Produto p4 = new Produto("Mesa de escritório", 300.00);
        Produto p5 = new Produto("Toalha", 50.00);
        Produto p6 = new Produto("Colcha", 200.00);
        Produto p7 = new Produto("TV true color", 1200.00);
        Produto p8 = new Produto("Roçadeira", 800.00);
        Produto p9 = new Produto("Abajour", 100.00);
        Produto p10 = new Produto("Pendente", 180.00);
        Produto p11 = new Produto("Shampoo", 90.00);

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().add(cat2);
        p5.getCategorias().add(cat3);
        p6.getCategorias().add(cat3);
        p7.getCategorias().add(cat4);
        p8.getCategorias().add(cat5);
        p9.getCategorias().add(cat6);
        p10.getCategorias().add(cat6);
        p11.getCategorias().add(cat7);

        catRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        proRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        Estado est1 = new Estado("Minas Gerais");
        Estado est2 = new Estado("São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        estRepository.saveAll(Arrays.asList(est1, est2));
        cidRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("28363323", "93898993"));

        Cliente cli2 = new Cliente("Pedro Silva", "Pedro@gmail.com", "363781252377", TipoCliente.PESSOAFISICA);
        cli2.getTelefones().addAll(Arrays.asList("28363583", "93498993"));

        Cliente cli3 = new Cliente("Silvio Silva", "silvio@gmail.com", "36378789377", TipoCliente.PESSOAFISICA);
        cli3.getTelefones().addAll(Arrays.asList("28324323", "93858893"));

        Endereco e1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardin", "38220834", cli1, c1);
        Endereco e2 = new Endereco("Avenida Matos", "102", "Sala 800", "Centro", "38777012", cli1, c2);

        cliRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
        endRepository.saveAll(Arrays.asList(e1, e2));

        Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(sdf.parse("10/10/2017 19:35"), cli1, e2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
        Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);
        Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);
        pedRepository.saveAll(Arrays.asList(ped1, ped2));
        pagRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        ipRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }

}
