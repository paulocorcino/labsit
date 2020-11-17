package io.labsit.restapibank.controller.dto;

import io.labsit.restapibank.controller.form.ContaCorrenteForm;
import io.labsit.restapibank.exception.ResourceNotFoundException;
import io.labsit.restapibank.model.Agencia;
import io.labsit.restapibank.model.ContaCorrente;
import io.labsit.restapibank.model.Pessoa;
import io.labsit.restapibank.model.Transacao;
import io.labsit.restapibank.repository.AgenciaRepository;
import io.labsit.restapibank.repository.ContaCorrenteRepository;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public class ContaCorrenteDTO {

    private Agencia agencia;
    private Long numConta;
    private Pessoa pessoa;
    private BigDecimal saldo;
    private List<Transacao> transacao;
    private ContaCorrente contaCorrente;

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Long getNumConta() {
        return numConta;
    }

    public void setNumConta(Long numConta) {
        this.numConta = numConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }

    public void setTransacao(List<Transacao> transacao) {
        this.transacao = transacao;
    }

    public ContaCorrenteDTO(){

    }

    public ContaCorrenteDTO(ContaCorrente contaCorrente) {
        this.agencia = contaCorrente.getAgencia();
        this.numConta = contaCorrente.getNumConta();
        this.pessoa = contaCorrente.getPessoa();
        this.saldo = contaCorrente.getSaldo();
        this.transacao = contaCorrente.getTransacao();
    }

    public ContaCorrenteDTO(AgenciaRepository agenciaRepository, ContaCorrenteRepository contaCorrenteRepository, Long numConta, Long numAgencia) {
        Agencia agencia;

        agencia = agenciaRepository.findByNumAgencia(numAgencia);
        if(agencia != null) {
            contaCorrente = contaCorrenteRepository.findByNumContaAndAgencia(numConta, agencia);
            if(contaCorrente != null) {
                this.agencia = contaCorrente.getAgencia();
                this.numConta = contaCorrente.getNumConta();
                this.pessoa = contaCorrente.getPessoa();
                this.saldo = contaCorrente.getSaldo();
                this.transacao = contaCorrente.getTransacao();
            } else
                throw new ResourceNotFoundException("Conta Corrente não encontrada.");
        } else
            throw new ResourceNotFoundException("Agencia não encontrada.");
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }
}
