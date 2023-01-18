package com.TesteAttornatus.TesteAttornatus.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "td_endereco")
public class EnderecoModel implements Serializable {
     private static final long serialVersionUID =1L;


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String Logradouro;
     private Integer CEP;
     private Integer numero;
     private String cidade;
     @JsonIgnore
     @ManyToOne
     @JoinColumn(name ="pessoa_id")
     private PessoaModel pessoa;

     public EnderecoModel(){}

     public EnderecoModel(Long id, String logrador, Integer CEP, Integer numero, String cidade, PessoaModel pessoa) {
          this.id = id;
          Logradouro = logrador;
          this.CEP = CEP;
          this.numero = numero;
          this.cidade = cidade;
          this.pessoa = pessoa;
     }

     public PessoaModel getPessoa() {
          return pessoa;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getLogrador() {
          return Logradouro;
     }

     public void setLogrador(String logrador) {
          Logradouro = logrador;
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

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          EnderecoModel that = (EnderecoModel) o;
          return id == that.id;
     }

     @Override
     public int hashCode() {
          return Objects.hash(id);
     }
}
