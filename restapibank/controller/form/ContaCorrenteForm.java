package io.labsit.restapibank.controller.form;

import io.labsit.restapibank.exception.InvalidOperationException;
import io.labsit.restapibank.exception.ResourceNotFoundException;
import io.labsit.restapibank.model.Agencia;
import io.labsit.restapibank.model.ContaCorrente;
import io.labsit.restapibank.model.Pessoa;
import io.labsit.restapibank.model.TypePessoa;
import io.labsit.restapibank.repository.AgenciaRepository;
import io.labsit.restapibank.repository.ContaCorrenteRepository;
import io.labsit.restapibank.repository.PessoaRepository;

import java.util.Optional;

public class ContaCorrenteForm {

    private Long numAgencia;
    private Long numConta;
    private String tpPessoa;
    private String idFederal;

     public Long getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(Long numAgencia) {
        this.numAgencia = numAgencia;
    }

    public Long getNumConta() {
        return numConta;
    }

    public void setNumConta(Long numConta) {
        this.numConta = numConta;
    }

    public String getTpPessoa() {
        return tpPessoa;
    }

    public void setTpPessoa(String tpPessoa) {
        this.tpPessoa = tpPessoa;
    }

    public String getIdFederal() {
        return idFederal;
    }

    public void setIdFederal(String idFederal) {
        this.idFederal = idFederal;
    }

    public ContaCorrente createContaCorrente(ContaCorrenteRepository contaCorrenteRepository, AgenciaRepository agenciaRepository, PessoaRepository pessoaRepository) {
        Agencia agencia;
        ContaCorrente contaCorrente;
        Pessoa pessoa;

        //find agencia on db
        agencia = agenciaRepository.findByNumAgencia(numAgencia);

        //if not exist create it
        if(agencia == null){
            agencia = new Agencia(numAgencia);
            agenciaRepository.save(agencia);
        } else {
            //find contacorrent
            if(Optional.ofNullable(contaCorrenteRepository.findByNumContaAndAgencia(numConta, agencia)).isPresent())
                throw new InvalidOperationException("Esta conta corrente existe neste agencia");
        }

        //find pessoa on db
        pessoa = pessoaRepository.findByIdFederal(idFederal);

        //if exist get pessoa
        if (pessoa == null) {
            TypePessoa typePessoa;
            if(tpPessoa.equalsIgnoreCase("PF"))
                typePessoa = TypePessoa.PF;
            else if (tpPessoa.equalsIgnoreCase("PJ"))
                typePessoa = TypePessoa.PJ;
            else
                throw new ResourceNotFoundException("Informe um tipo de pessoa PF ou PJ");

            pessoa = new Pessoa(idFederal, typePessoa);
            pessoaRepository.save(pessoa);
        }

        contaCorrente = new ContaCorrente(numConta, agencia, pessoa);

        return contaCorrente;
    }
}
