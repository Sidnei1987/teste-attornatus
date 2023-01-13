package com.TesteAttornatus.TesteAttornatus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id;
     String Logrador;
     Integer CEP;
     Integer numero;
     String cidade;

     @ManyToOne
     private static Pessoa pessoa = new Pessoa();
}
