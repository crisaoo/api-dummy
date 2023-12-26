# API Dummy
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/crisaoo/api-dummy/blob/main/LICENSE)

## Sobre o projeto

O objetivo deste projeto é fornecer uma API modelo que siga os padrões REST.

A ideia principal é que os princípios que foram utilizados para a construção desta API possam ser reutilizados para qualquer aplicação, seguindo suas especificidades. 

## Tecnologias utilizadas

### Back end

- Java
- Spring Boot
- JPA 
- Maven

### Database

- H2
- PostgreSQL 

## Arquitetura

O fluxo de requisições de uma transação do back end para uma aplicação que a solicita funciona da seguinte maneira:

1. Os repositories (camada de acesso a dados) realizam a consulta com o banco de dados para obter a informação e a envia para a camada de serviço.
2. Os services (camada de serviço) aplicam quaisquer regras de negócio nos dados e então enviam somente as informações necessárias (DTO) para a camada de controladores REST.
3. Os controllers (camada de controladores REST) tratam então esses dados e enviam no formato JSON para a aplicação requisitora.


<img src="https://drive.google.com/uc?export=view&id=1gj1eAJHp7ZejB95JqdVbY8AkcjN6PyHU" width=800>




## Modelo de Domínio

O diagrama UML abaixo representa as entidades atuantes no projeto.

O domínio principal deste projeto é composto pelas entidades **Pokemon** e **Pokeball**. 

As entidades **PokemonType** e **Pokeball** são do tipo *enum* e são compostas por valores constantes com seus códigos inteiros correspondentes, representando assim os tipos disponíveis de pokemons e pokeballs, respectivamente. 

A entidade **PokemonCapturedByPokeball** tem como objetivo representar uma classe de associação de um pokemon capturado por uma pokeball. 

Futuramente, pretendo expandir esse modelo e adicionar também uma classe para representar um **Trainer**. No momento, ele está sendo representado por uma String.



<img src="https://drive.google.com/uc?export=view&id=1r16YKfjvtxX5qwDbsWLpjq-N0VVgqtFn" width=800 height=1000>



## Endpoints

usar swagger


## Como executar o projeto 

Pré-requisitos: 

- Java 21

```bash
# clonar repositório
git clone https://github.com/crisaoo/api-dummy.git

# entrar na pasta do projeto
cd api-dummy

# executar o projeto
./mvnw spring-boot:run
```

## Autor

[Cristiano Costa Batista](https://www.linkedin.com/in/cristiano-costa-709469203)