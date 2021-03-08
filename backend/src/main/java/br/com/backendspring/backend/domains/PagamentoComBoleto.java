package br.com.backendspring.backend.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.backendspring.backend.domains.enums.EstadoPagamento;

@Entity
@Table(name = "tb_pagamento_boleto")
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;

    public PagamentoComBoleto() {

    }

    public PagamentoComBoleto(EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
