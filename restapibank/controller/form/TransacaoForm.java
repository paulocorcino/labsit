package io.labsit.restapibank.controller.form;

import io.labsit.restapibank.model.ContaCorrente;
import io.labsit.restapibank.repository.ContaCorrenteRepository;

import java.math.BigDecimal;

public class TransacaoForm {
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TransacaoForm(BigDecimal valor) {
        this.valor = valor;
    }

    public ContaCorrente executeTransacao(ContaCorrenteRepository contaCorrenteRepository){

    }

}
