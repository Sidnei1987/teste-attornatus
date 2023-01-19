package com.TesteAttornatus.TesteAttornatus.services;

import com.TesteAttornatus.TesteAttornatus.entities.Pessoa;
import com.TesteAttornatus.TesteAttornatus.exeption.EntidadeNaoEncontradaException;
import com.TesteAttornatus.TesteAttornatus.repositories.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PessoaService {


    private PessoaRepository pessoaRepository;
    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getList(){
        return pessoaRepository.findAll();
    }

    public Pessoa getPessoa(Long id){
        return findOrFail(id);
    }

    public Pessoa savePessoa(Pessoa pessoa){
        pessoa.getEndereco().forEach(c -> c.setPessoa(pessoa));
        return pessoaRepository.save(pessoa);
    }
    public Pessoa updatePessoa(Long id, Pessoa pessoa){
        Pessoa pessoaSave = findOrFail(id);

        pessoaSave.getEndereco().clear();
        pessoaSave.getEndereco().addAll(pessoa.getEndereco());
        BeanUtils.copyProperties(pessoa,pessoaSave,"id","pessoa");
        return pessoaRepository.save(pessoaSave);
    }
    public void deletePessoa(Long id){
        Pessoa pessoa = findOrFail(id);
        pessoaRepository.delete(pessoa);
    }
    private Pessoa findOrFail(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Pessoa não localizada"));
    }

}

