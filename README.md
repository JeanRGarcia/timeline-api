# Timeline API

API REST em Java para servir os dados do meu currículo em linha do tempo
([Resume Timeline](https://github.com/JeanRGarcia/resume-timeline)).

> **Status: em desenvolvimento.** Projeto de estudo construído passo a passo.
> O banco e o schema já existem; os endpoints ainda estão sendo implementados.

## Stack

- Java 21
- Spring Boot 4.1 (Web MVC, Data JPA, Validation)
- PostgreSQL 17 (via Docker no desenvolvimento)
- Flyway (migrations versionadas)
- Maven (Maven Wrapper incluído)

## Rodando localmente

Pré-requisitos: JDK 21 ou superior e Docker.

```bash
docker compose up -d      # sobe o PostgreSQL
./mvnw spring-boot:run    # sobe a API em http://localhost:8080
```

A conexão com o banco usa as variáveis `DB_URL`, `DB_USERNAME` e `DB_PASSWORD`.
Os valores padrão já batem com o `docker-compose.yml`.

## Roadmap

- [x] Projeto base com Spring Boot, Maven e PostgreSQL via Docker Compose
- [x] Migrations com Flyway (tabela `timeline_item`)
- [x] Enum `TimelineItemType`
- [x] Entidade e repositório JPA
- [ ] Endpoints REST (CRUD) dos itens da timeline
- [ ] Validação e tratamento de erros
- [ ] Autenticação com JWT nas rotas de escrita
- [ ] Testes automatizados (JUnit e Testcontainers)
- [ ] Documentação OpenAPI e deploy