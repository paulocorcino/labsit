package io.labsit.restapibank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agencia")
public class Agencia {
    @Id
    private Long num_agencia;

    public Long getNum_agencia() {
        return num_agencia;
    }

    public void setNum_agencia(Long num_agencia) {
        this.num_agencia = num_agencia;
    }

    public Agencia(Long num_agencia) {
        this.num_agencia = num_agencia;
    }
}
