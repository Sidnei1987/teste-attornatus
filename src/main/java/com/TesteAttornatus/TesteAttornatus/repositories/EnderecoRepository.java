package com.TesteAttornatus.TesteAttornatus.repositories;

import com.TesteAttornatus.TesteAttornatus.entities.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoModel,Long> {


}
