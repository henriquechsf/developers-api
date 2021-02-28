# API Rest - Developers

---

## Tecnologias usadas
- [Java 11 - OpenJDK](https://openjdk.java.net/) - Linguagem de Programação
- [Spring-Boot](https://spring.io/projects/spring-boot) - Framework Rotas HTTP
- [Maven](https://maven.apache.org/) - Pacote de dependências
- [Flyway](https://flywaydb.org/) - Migrations base de dados

---

### Requerimentos
[x] Docker instalado na máquina host

### Utilização
1. Clone o repositório do Github
```
git clone 
```

2. No terminal execute o build Docker
```
docker-compose up --build
```

---

## Endpoints

#### Listar todos desenvolvedores 
**GET** `/developers` 
Resposta Sucesso: `Code 200 OK`

---

#### Listar desenvolvedores por paginação 
**GET** `/developers/page?limit=10&page=1` 
Resposta Sucesso: `Code 200 OK`

---

#### Listar desenvolvedores por ID
**GET** `/developers/:id` 
Resposta Sucesso: `Code 200 OK`
Resposta Erro: `Code 404 NOT FOUND`

---

#### Adicionar desenvolvedor
**POST** `/developers` 
Resposta Sucesso: `Code 201 CREATED`
Resposta Erro: `Code 400 BAD REQUEST`

*Exemplo dados requisição*:
```json
    {
    "nome": "Jon Doe",
    "sexo": "M",
    "idade": 21,
    "hobby": "Futebol",
    "nascimento": "2000-01-01"
  }
```

---

#### Atualizar dados desenvolvedor
**PUT** `/developers/:id` 
Resposta Sucesso: `Code 200 OK`
Resposta Erro: `Code 400 BAD REQUEST`

---

#### Excluir desenvolvedor
**DELETE** `/developers/:id` 
Resposta Sucesso: `Code 204 NO CONTENT`
Resposta Erro: `Code 400 BAD REQUEST`
