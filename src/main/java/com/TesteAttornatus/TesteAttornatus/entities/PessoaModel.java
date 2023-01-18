package com.TesteAttornatus.TesteAttornatus.entities;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cliente")
public class PessoaModel implements Serializable {
        private static final long serialVersionUID =1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String dataDeNacimento;
        @OneToMany(mappedBy = "pessoa")
        private List<EnderecoModel> enderecos = new ArrayList<>();

        public PessoaModel() {
        }

        public List<EnderecoModel> getEnderecos() {
                return enderecos;
        }


        public PessoaModel(Long id, String nome, String dataDeNacimento) {
                this.id = id;
                this.nome = nome;
                this.dataDeNacimento = dataDeNacimento;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                PessoaModel that = (PessoaModel) o;
                return id == that.id;
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }


}