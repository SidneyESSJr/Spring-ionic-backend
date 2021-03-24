package br.com.backend.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.backend.domains.enums.EstadoPagamento;

@Entity
@Table(name = "tb_pagamento_cartao")
@JsonTypeName("pagamentoComCartao") // utilizada para identificar a subclasse no atributo @type do objeto pagamento
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {

    }

    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroDeParcelas) {
        super(estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

}
