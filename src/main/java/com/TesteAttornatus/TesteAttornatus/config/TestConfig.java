package com.TesteAttornatus.TesteAttornatus.config;

import com.TesteAttornatus.TesteAttornatus.entities.EnderecoModel;
import com.TesteAttornatus.TesteAttornatus.entities.PessoaModel;
import com.TesteAttornatus.TesteAttornatus.repositories.EnderecoRepository;
import com.TesteAttornatus.TesteAttornatus.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Override
    public void run(String... args) throws Exception {

       PessoaModel pessoa1 = new  PessoaModel(null,"Sidnei Mendes","07061987");
       PessoaModel pessoa2 = new  PessoaModel(null,"Gabi Mendes","170295");
       PessoaModel pessoa3 = new  PessoaModel(null,"Luan Mendes","161091");
       PessoaModel pessoa4 = new  PessoaModel(null,"Jonas Teixeira","131089");

       EnderecoModel endereco1 = new EnderecoModel(null,"belmira",232220,832,"sp",pessoa1);
       EnderecoModel endereco2 = new EnderecoModel(null,"salvado",232220,832,"sp",pessoa2);
       EnderecoModel endereco3 = new EnderecoModel(null,"isabel",2348,832,"sp",pessoa1);
       EnderecoModel endereco4 = new EnderecoModel(null,"jequer",483600,832,"sp",pessoa3);
       EnderecoModel endereco5 = new EnderecoModel(null,"esteves",83600,832,"sp",pessoa4);

       pessoaRepository.saveAll(Arrays.asList(pessoa1,pessoa2,pessoa3,pessoa4));
       enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2,endereco3,endereco4,endereco5));

    }
}
