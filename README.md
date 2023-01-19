# teste-attornatus
Projeto back-end responsavel por criar um CRUD para pessoa, endereço e estabelece uma relação entre eles. 


### Stack

| Tecnologia     | Versão   |
|----------------|----------|
| Java           |   17     |
| SpringBoot     | 3.0.1    |


### Executando a Aplicação

    # Clone o projeto
    git clone https://github.com/Sidnei1987/teste-attornatus

    # Para subir a aplicação
      Configura um banco local H2
      Start o projeto atravez da class main
    
      # Exemplo configuração application.properties de banco H2:
      
        spring.profiles.active=test
        spring.jpa.open-in-view=true
        # DATASOURCE
        spring.datasource.driverClassName=org.h2.Driver
        spring.datasource.url=jdbc:h2:mem:testdb
        spring.datasource.username=sa
        spring.datasource.password=
        # H2 CLIENT
        spring.h2.console.enabled=true
        spring.h2.console.path=/h2-console
        # JPA, SQL
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
        spring.jpa.defer-datasource-initialization=true
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.format_sql=true

        
### Testar o projeto
  Ultilize o postman
  
    Para listar os pessoa/endereço curl --location --request GET 'http://localhost:8080/pessoa'

    Para criar os pessoa/endereço curl --location --request POST 'http://localhost:8080/pessoa'

    para atualizar o pessoa/endereço curl --location --request PUT 'http://localhost:8080/pessoa/{id}'

    para deletar pessoa/endereço  => curl --location --request DELETE 'http://localhost:8080/pessoa/{id}'
    
    ### Request
    {
    
    "nome": null,
    "dataDeNacimento": null,
    "endereco": [
        {
            
            "numero": null,
            "cidade": null,
            "logradouro": null,
            "cep": null
        }
    ]
}
    
  
