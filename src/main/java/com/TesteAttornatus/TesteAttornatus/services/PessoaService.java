package com.TesteAttornatus.TesteAttornatus.services;

import com.TesteAttornatus.TesteAttornatus.entities.EnderecoModel;
import com.TesteAttornatus.TesteAttornatus.entities.PessoaModel;
import com.TesteAttornatus.TesteAttornatus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    private PessoaModel pessoaModel;

    private EnderecoModel enderecoModel;

    public List<PessoaModel> findAll(){
        return repository.findAll();
    }

    public PessoaModel findById(Long id){
        Optional<PessoaModel> obj = repository.findById(id);
        return obj.get();
    }
    public PessoaModel insert(PessoaModel obj){
        return repository.save(obj);
    }
    public PessoaModel update(Long id, PessoaModel obj){
        PessoaModel entity = repository.getReferenceById(id);
        updateData(entity, enderecoModel);
        return repository.save(entity);
    }

    public PessoaModel updateData(PessoaModel entity, EnderecoModel endereco) {
        entity.setNome(entity.getNome());
        entity.setDataDeNacimento(entity.getDataDeNacimento());
        endereco.setLogrador(endereco.getLogrador());
        endereco.setCEP(endereco.getCEP());
        endereco.setNumero(endereco.getNumero());
        endereco.setCidade(endereco.getCidade());
        return entity;
    }

}

