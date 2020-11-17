package io.labsit.restapibank.repository;

import io.labsit.restapibank.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    Agencia findByNumAgencia(Long numAgencia);
}
