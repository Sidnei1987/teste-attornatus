package com.TesteAttornatus.TesteAttornatus.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false, length = 100)
        private String nome;
        @Column(nullable = false, length = 10)
        private String dataDeNacimento;
        @JsonIgnoreProperties("pessoa")
        @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
        private List<Endereco> endereco = new ArrayList<>();

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getDataDeNacimento() {
                return dataDeNacimento;
        }

        public void setDataDeNacimento(String dataDeNacimento) {
                this.dataDeNacimento = dataDeNacimento;
        }

        public List<Endereco> getEndereco() {
                return endereco;
        }

        public void setEndereco(List<Endereco> endereco) {
                this.endereco = endereco;
        }
}