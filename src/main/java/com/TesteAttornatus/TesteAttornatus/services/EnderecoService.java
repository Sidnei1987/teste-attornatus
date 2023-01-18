package com.TesteAttornatus.TesteAttornatus.services;

import com.TesteAttornatus.TesteAttornatus.entities.EnderecoModel;
import com.TesteAttornatus.TesteAttornatus.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoModel> findAll(){
        return repository.findAll();
    }

    public EnderecoModel findById(Long id){
        Optional<EnderecoModel> enderecoModel = repository.findById(id);
        return enderecoModel.get();
    }
    public EnderecoModel insertEndereco(EnderecoModel enderecoModel){
        return repository.save(enderecoModel);
    }
}
