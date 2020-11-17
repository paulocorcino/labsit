package io.labsit.restapibank.repository;

import io.labsit.restapibank.model.Agencia;
import io.labsit.restapibank.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    ContaCorrente findByNumContaAndAgencia(Long numConta, Agencia agencia);

}
