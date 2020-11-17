package io.labsit.restapibank.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Agencia")
public class Agencia {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "num_agencia")
    private Long numAgencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(Long numAgencia) {
        this.numAgencia = numAgencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return id.equals(agencia.id) &&
                numAgencia.equals(agencia.numAgencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numAgencia);
    }

    public  Agencia() {

    }

    public Agencia(Long numAgencia) {
        this.numAgencia = numAgencia;
    }
}
