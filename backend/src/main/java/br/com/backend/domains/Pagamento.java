package br.com.backend.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.backend.domains.enums.EstadoPagamento;

@Entity
@Table(name = "tb_pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Integer estadoPagamento;

    @MapsId
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pagamento() {

    }

    public Pagamento(EstadoPagamento estadoPagamento, Pedido pedido) {
        this.estadoPagamento = estadoPagamento.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(this.estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCod();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}