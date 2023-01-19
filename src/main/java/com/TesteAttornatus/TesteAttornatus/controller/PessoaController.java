package com.TesteAttornatus.TesteAttornatus.controller;

import com.TesteAttornatus.TesteAttornatus.entities.Pessoa;
import com.TesteAttornatus.TesteAttornatus.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    PessoaRepository repository;

    @GetMapping
    public List<Pessoa> getAllPessoas(){

        return repository.findAll();
    }
    @GetMapping("/pessoa/{id}")
    public Pessoa getPessoaById(@PathVariable Long id){
        return repository.getOne(id);// se der o mesmo erro deve ser aqui o problema
    }

    @PostMapping
    public Pessoa savePessoa(@RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @DeleteMapping ("/pessoa/{id}")
    public void deletePessoa(@PathVariable Long id){
        repository.deleteById(id);
    }

}
