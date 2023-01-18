package com.TesteAttornatus.TesteAttornatus.repositories;

import com.TesteAttornatus.TesteAttornatus.entities.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel,Long> {


}
