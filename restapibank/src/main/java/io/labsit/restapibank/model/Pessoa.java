package io.labsit.restapibank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Pessoa")
public class Pessoa {

    public enum typeof_pessoa {
        pf,pj;
    }

    @Id
    @Column(name = "id_federal")
    private String id_federal;

    @Column(name = "tp_pessoa")
    private typeof_pessoa tp_pessoa;

    public String getId_federal() {
        return id_federal;
    }

    public void setId_federal(String id_federal) {
        this.id_federal = id_federal;
    }

    public typeof_pessoa getTp_pessoa() {
        return tp_pessoa;
    }

    public void setTp_pessoa(typeof_pessoa tp_pessoa) {
        this.tp_pessoa = tp_pessoa;
    }

    public Pessoa(String id_federal, typeof_pessoa tp_pessoa) {
        this.id_federal = id_federal;
        this.tp_pessoa = tp_pessoa;
    }
}
