package br.com.backend.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.backend.domains.ItemPedido;
import br.com.backend.domains.PagamentoComBoleto;
import br.com.backend.domains.Pedido;
import br.com.backend.domains.enums.EstadoPagamento;
import br.com.backend.repositories.ItemPedidoRepository;
import br.com.backend.repositories.PagamentoRepository;
import br.com.backend.repositories.PedidoRepository;
import br.com.backend.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmailService emailService;

    public Pedido findById(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    @Transactional
    public Pedido save(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteService.findById(obj.getCliente().getId()));
        obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = pedidoRepository.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido p : obj.getItens()) {
            p.setDesconto(0.0);
            p.setProduto(produtoService.findById(p.getProduto().getId()));
            p.setPreco(p.getProduto().getPreco());
            p.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        emailService.sendOrderConfirmationEmail(obj);
        return obj;
    }
}
