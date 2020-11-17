package io.labsit.restapibank.controller;

import io.labsit.restapibank.controller.dto.ContaCorrenteDTO;
import io.labsit.restapibank.controller.dto.ContaCorrenteSaldoDTO;
import io.labsit.restapibank.controller.form.ContaCorrenteForm;
import io.labsit.restapibank.controller.form.TransacaoForm;
import io.labsit.restapibank.model.Agencia;
import io.labsit.restapibank.model.ContaCorrente;
import io.labsit.restapibank.repository.AgenciaRepository;
import io.labsit.restapibank.repository.ContaCorrenteRepository;
import io.labsit.restapibank.repository.PessoaRepository;
import io.labsit.restapibank.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/contacorrente")
public class BankController {

    private ContaCorrente contaCorrente;
    private Agencia agencia;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    /*
    Cadastrar cliente
    Atualizar cliente
    Sacar
    Depositar
    Consultar saldo
    Consultar extrato
    */

    @PostMapping("/cliente")
    public ResponseEntity<ContaCorrenteDTO> createCliente(@RequestBody ContaCorrenteForm form, UriComponentsBuilder uriBuilder) {
        contaCorrente = form.createContaCorrente(contaCorrenteRepository, agenciaRepository, pessoaRepository);
        contaCorrenteRepository.save(contaCorrente);

        URI uri = uriBuilder.path("/contacorrente/cliente/{numAgencia}/{numConta}").buildAndExpand(contaCorrente.getAgencia().getNumAgencia(), contaCorrente.getNumConta()).toUri();
        return ResponseEntity.created(uri).body(new ContaCorrenteDTO(contaCorrente));
    }

    @GetMapping("/cliente/{numAgencia}/{numConta}")
    public ResponseEntity<ContaCorrenteDTO> getCliente(@PathVariable Long numAgencia, @PathVariable Long numConta){
        ContaCorrenteDTO contaCorrenteDTO = new ContaCorrenteDTO(agenciaRepository, contaCorrenteRepository, numConta, numAgencia);
        return  ResponseEntity.ok().body(contaCorrenteDTO);
    }

    @PutMapping("/cliente/{numAgencia}/{numConta}")
    public ResponseEntity<ContaCorrenteDTO> updateCliente(@PathVariable Long numAgencia, @PathVariable Long numConta, @RequestBody ContaCorrenteForm form, UriComponentsBuilder uriBuilder) {
        ContaCorrenteDTO contaCorrenteDTO = new ContaCorrenteDTO(agenciaRepository, contaCorrenteRepository, numConta, numAgencia);
        return ResponseEntity.ok().body(contaCorrenteDTO);
    }

    @GetMapping("/saldo/{numAgencia}/{numConta}")
    public ResponseEntity<ContaCorrenteSaldoDTO> getSaldo(@PathVariable Long numAgencia, @PathVariable Long numConta) {
        ContaCorrenteDTO contaCorrenteDTO = new ContaCorrenteDTO(agenciaRepository, contaCorrenteRepository, numConta, numAgencia);
        return ResponseEntity.ok().body(new ContaCorrenteSaldoDTO(contaCorrenteDTO));
    }

    @PostMapping("/depositar/{numAgencia}/{numConta}")
    public ResponseEntity<ContaCorrenteSaldoDTO> setDeposito(@PathVariable Long numAgencia, @PathVariable Long numConta, @RequestBody TransacaoForm form) {
        ContaCorrenteDTO contaCorrenteDTO = new ContaCorrenteDTO(agenciaRepository, contaCorrenteRepository, numConta, numAgencia);

    }

}
