package com.TesteAttornatus.TesteAttornatus.controller;

import com.TesteAttornatus.TesteAttornatus.entities.Pessoa;
import com.TesteAttornatus.TesteAttornatus.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    private PessoaService pessoaService;
    @Autowired
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> List(){
        return pessoaService.getList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa>getById(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.getPessoa(id));
    }
    @PostMapping
    public ResponseEntity<Pessoa> save (@RequestBody Pessoa pessoa){
        Pessoa p = pessoaService.savePessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa){
        return ResponseEntity.ok(pessoaService.updatePessoa(id, pessoa));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        pessoaService.deletePessoa(id);
    }


}
