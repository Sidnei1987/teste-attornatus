package com.TesteAttornatus.TesteAttornatus.controller;


import com.TesteAttornatus.TesteAttornatus.entities.EnderecoModel;
import com.TesteAttornatus.TesteAttornatus.entities.PessoaModel;
import com.TesteAttornatus.TesteAttornatus.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> findAll(){
        List<EnderecoModel> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoModel> findById(@PathVariable Long id){
        EnderecoModel obj  = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }
    @PostMapping
    public ResponseEntity<EnderecoModel > insert(@RequestBody EnderecoModel enderecoModel){
        enderecoModel = service.insertEndereco(enderecoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(enderecoModel.getId()).toUri();
        return ResponseEntity.created(uri ).body(enderecoModel);
    }



}
