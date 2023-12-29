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

As entidades **PokemonType** e **PokeballType** são do tipo *enum* e são compostas por valores constantes com seus códigos inteiros correspondentes, representando assim os tipos disponíveis de pokemons e pokeballs, respectivamente. 

A entidade **CatchRate** representa a taxa de captura de uma pokebola para N tipos de pokemon. Essa taxa ignora outras dados como a saúde e status do pokemon (atributos que posteriormente podem ser implementados), levando em conta apenas o tipo da pokeball e o tipo do pokemon. Por exemplo, uma pokeball do tipo Safari tem um catch rate de 1.5x para pokemons do tipo Grass, porém, para outros pokemons, a catch rate é de apenas 1x.

A entidade **PokemonCapturedByPokeball** tem como objetivo representar uma classe de associação de um pokemon capturado por uma pokeball. 

Futuramente, pretendo expandir esse modelo e adicionar também uma classe para representar um **Trainer**. No momento, ele está sendo representado por uma String.



<img src="https://drive.google.com/uc?export=view&id=1A0P7elTKc0wSq2mdn4So-S0frICZnUe0" width=800 >



## Endpoints

usar swagger

## Perfis de projeto

Antes de executar o projeto, é preciso determinar qual o perfil que irá rodar a aplicação. Há 3 perfis:

- **test**: Perfil default do projeto, utiliza o banco de dados em memória H2, então não é necessário nenhuma instalação prévia. O banco já está populado, o arquivo de seeding está localizado em `/src/main/resources/import.sql`.
- **dev**: Este perfil utiliza o banco de dados postgres, então é necessário criar e configurar o banco de dados. O arquivo `create.sql` para a criação e população das tabelas está localizado na pasta raiz. Em relação a instalação do banco, há 2 alternativas:
    - instalar o postgresql na máquina;
    - utilizar o docker-compose para criar os containers do PostgreSQL e PGadmin. O arquivo para a criação dos containeres está localizado em `/docker/docker-compose.yml`.
 

- **prod**: Perfil destinado para uma futura implantação na nuvem. 

Para mudar o perfil do projeto, basta acessar o arquivo `application.properties` localizado no diretório `/src/main/resources/` e alterar a variável `APP_PROFILE`. Os outros arquivos properties são especificações de cada perfil..

## Como executar o projeto 

Pré-requisitos: 

- Java 21
- Docker/docker-compose ou PostgreSQL (para o perfil dev)

Clonar o repositório:

```bash
git clone https://github.com/crisaoo/api-dummy.git
```

Caso esteja no perfil dev e opte por usar o docker para criar o container do postgresql/pgadmin:

```bash
# entrar na pasta do arquivo de criação dos containers
cd api/docker

# subir as imagens
docker-compose up -d

# sair da pasta do projeto
cd ../..
```

Para executar o projeto:
```bash
# entrar na pasta do projeto
cd api-dummy

# executar o projeto
./mvnw spring-boot:run
```

## Autor

[Cristiano Costa Batista](https://www.linkedin.com/in/cristiano-costa-709469203)