package com.TesteAttornatus.TesteAttornatus.controller;

import com.TesteAttornatus.TesteAttornatus.entities.EnderecoModel;
import com.TesteAttornatus.TesteAttornatus.entities.PessoaModel;
import com.TesteAttornatus.TesteAttornatus.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;


    @GetMapping
    public ResponseEntity<List<PessoaModel>> findAll(){
        List<PessoaModel> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaModel> findById(@PathVariable Long id){
        PessoaModel pessoaModel  = service.findById(id);
        return ResponseEntity.ok().body(pessoaModel);

    }
    @PostMapping
    public ResponseEntity<PessoaModel> insert(@RequestBody PessoaModel pessoaModel, EnderecoModel endereco){
        pessoaModel = service.insert(pessoaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(service.updateData(pessoaModel, endereco));
    }
    //gab
//    @PostMapping
//    public ResponseEntity<PessoaModel> post (@RequestBody PessoaModel pessoaModel) {
//        return ResponseEntity.ok().body(service.cadastraPessoa());
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaModel> update(@PathVariable Long id,@RequestBody PessoaModel pessoaModel){
        pessoaModel = service.update(id,pessoaModel);
        return ResponseEntity.ok().body(pessoaModel);
    }


}
