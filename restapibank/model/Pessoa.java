package io.labsit.restapibank.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_federal")
    private String idFederal;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_pessoa")
    private TypePessoa tpPessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdFederal() {
        return idFederal;
    }

    public void setIdFederal(String idFederal) {
        this.idFederal = idFederal;
    }

    public TypePessoa getTpPessoa() {
        return tpPessoa;
    }

    public void setTpPessoa(TypePessoa tpPessoa) {
        this.tpPessoa = tpPessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id) &&
                idFederal.equals(pessoa.idFederal) &&
                tpPessoa == pessoa.tpPessoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFederal, tpPessoa);
    }

    public Pessoa(){

    }

    public Pessoa(String idFederal, TypePessoa tpPessoa) {
        this.idFederal = idFederal;
        this.tpPessoa = tpPessoa;
    }
}
