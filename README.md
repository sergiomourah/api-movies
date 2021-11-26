# Especificação

Desenvolvimento de uma API RESTful para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

## Requisito do Sistema:
1. Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao iniciar a
aplicação.

## Requisito da API:
1. Obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido;

## Tecnologias
- Java
- Spring Boot
- H2
- Open CSV
- Maven

##### Endpoint API
- http://localhost:8080/api/producer/period-interval

##### Executar o projeto
- Executar o projeto mvn spring-boot:run

##### Banco de dados
- Acessar o banco H2
    - Executar aplicação
    - Gerenciador do Banco: (http://localhost:8080/h2-ui)
    - Url: jdbc:h2:mem:movies
    - Login: root
    - Senha:
    
##### Formato da API
````{
  "min": [
    {
      "producer": "Producer 1",
      "interval": 1,
      "previousWin": 2008,
      "followingWin": 2009
    },
    {
      "producer": "Producer 2",
      "interval": 1,
      "previousWin": 2018,
      "followingWin": 2019
    }
  ],
  "max": [
    {
      "producer": "Producer 1",
      "interval": 99,
      "previousWin": 1900,
      "followingWin": 1999
    },
    {
      "producer": "Producer 2",
      "interval": 99,
      "previousWin": 2000,
      "followingWin": 2099
    }
  ]
}