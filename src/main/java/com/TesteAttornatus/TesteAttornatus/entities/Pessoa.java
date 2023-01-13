package com.TesteAttornatus.TesteAttornatus.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nome;
        private String dataDeNacimento;


        @OneToMany
        @JoinColumn(name = "endereco_id")
        private static Endereco endereco = new Endereco();




}