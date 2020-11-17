package io.labsit.restapibank.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ContaCorrente")
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_conta")
    private Long numConta;

    @Column(name = "saldo")
    private BigDecimal saldo = new BigDecimal(0.0);

    @ManyToOne
    private Agencia agencia;

    @OneToOne
    private Pessoa pessoa;

    @OneToMany
    private List<Transacao> transacao = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumConta() {
        return numConta;
    }

    public void setNumConta(Long numConta) {
        this.numConta = numConta;
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

    public ContaCorrente(Long numConta, BigDecimal saldo, Agencia agencia, Pessoa pessoa, List<Transacao> transacao) {
        this.numConta = numConta;
        this.saldo = saldo;
        this.agencia = agencia;
        this.pessoa = pessoa;
        this.transacao = transacao;
    }

    public ContaCorrente(){

    }

    public ContaCorrente(Long numConta, Agencia agencia, Pessoa pessoa) {
        this.numConta = numConta;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(numConta, that.numConta) &&
                Objects.equals(saldo, that.saldo) &&
                Objects.equals(agencia, that.agencia) &&
                Objects.equals(pessoa, that.pessoa) &&
                Objects.equals(transacao, that.transacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numConta, saldo, agencia, pessoa, transacao);
    }
}
