package io.labsit.restapibank.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Transacao")
public class Transacao {

    @CreationTimestamp
    private Date data;

    @Column(name = "valor")
    private BigDecimal valor;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Transacao(Date data, BigDecimal valor) {
        this.data = data;
        this.valor = valor;
    }
}


