package com.TesteAttornatus.TesteAttornatus.entities;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
     private static final long serialVersionUID = 1L;


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(nullable = false, length = 100)
     private String Logradouro;
     @Column(nullable = false, length = 10)
     private Integer CEP;
     @Column(nullable = false, length = 15)
     private Integer numero;
     @Column(nullable = false, length = 30)
     private String cidade;


     @ManyToOne
     @JoinColumn(name = "id_pessoa")
     private Pessoa pessoa;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getLogradouro() {
          return Logradouro;
     }

     public void setLogradouro(String logradouro) {
          Logradouro = logradouro;
     }

     public Integer getCEP() {
          return CEP;
     }

     public void setCEP(Integer CEP) {
          this.CEP = CEP;
     }

     public Integer getNumero() {
          return numero;
     }

     public void setNumero(Integer numero) {
          this.numero = numero;
     }

     public String getCidade() {
          return cidade;
     }

     public void setCidade(String cidade) {
          this.cidade = cidade;
     }

     public Pessoa getPessoa() {
          return pessoa;
     }

     public void setPessoa(Pessoa pessoa) {
          this.pessoa = pessoa;
     }
}

