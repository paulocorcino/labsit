package io.labsit.restapibank.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ContaCorrente")
public class ContaCorrente {

    @Id
    private Long num_conta;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "agencia")
    private Agencia agencia;

    @Column(name = "pessoa")
    private Pessoa pessoa;

    @Column(name = "transacao")
    private List<Transacao> transacao = new ArrayList<>();

    public Long getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(Long num_conta) {
        this.num_conta = num_conta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }

    public void setTransacao(List<Transacao> transacao) {
        this.transacao = transacao;
    }

    public ContaCorrente(Long num_conta, Agencia agencia, Pessoa pessoa) {
        this.num_conta = num_conta;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }
}
