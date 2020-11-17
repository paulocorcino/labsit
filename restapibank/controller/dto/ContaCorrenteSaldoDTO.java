package io.labsit.restapibank.controller.dto;

import io.labsit.restapibank.model.Agencia;
import io.labsit.restapibank.model.ContaCorrente;

import java.math.BigDecimal;

public class ContaCorrenteSaldoDTO {

    private Agencia agencia;
    private Long numConta;
    private BigDecimal saldo;

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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public ContaCorrenteSaldoDTO(ContaCorrenteDTO contaCorrenteDTO) {
        this.agencia = contaCorrenteDTO.getAgencia();
        this.numConta = contaCorrenteDTO.getNumConta();
        this.saldo = contaCorrenteDTO.getSaldo();
    }

    public ContaCorrenteSaldoDTO(ContaCorrente contaCorrente) {
        this.agencia = contaCorrente.getAgencia();
        this.numConta = contaCorrente.getNumConta();
        this.saldo = contaCorrente.getSaldo();
    }

}
