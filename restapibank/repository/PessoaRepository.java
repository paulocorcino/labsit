package io.labsit.restapibank.repository;

import io.labsit.restapibank.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByIdFederal(String idfederal);
}
