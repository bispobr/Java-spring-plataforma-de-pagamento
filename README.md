# Java Spring - Plataforma de Pagamentos

API REST desenvolvida com Java e Spring Boot para simular uma plataforma de pagamentos, permitindo transferências de valores entre usuários de acordo com as regras de negócio definidas para cada tipo de usuário.

O projeto utiliza carteiras com saldo disponível e implementa validações relacionadas à realização de transferências.

## Funcionalidades

- Cadastro de usuários
- Listagem de usuários
- Cadastro de usuários comuns e lojistas
- Transferência de valores entre usuários
- Controle de saldo das carteiras
- Validação de saldo disponível antes da transferência
- Restrição para que usuários lojistas não realizem transferências
- CPF/CNPJ e e-mail únicos
- Persistência utilizando H2 Database

## Regras de negócio

### Usuários

Cada usuário possui informações como:

- Nome completo
- CPF/CNPJ
- E-mail
- Senha
- Tipo de usuário
- Saldo disponível

CPF/CNPJ e e-mail devem ser únicos no sistema.

### Transferências

Para realizar uma transferência:

1. O usuário remetente deve possuir saldo suficiente.
2. O destinatário deve ser um usuário válido.
3. Usuários lojistas não podem realizar transferências.
4. O valor da transferência deve ser válido.
5. O saldo dos envolvidos deve ser atualizado de acordo com a operação.

Fluxo simplificado:

```text
Remetente
   │
   │ valor
   ▼
Validação de regras
   │
   ├── saldo disponível?
   ├── usuário permitido?
   └── destinatário válido?
          │
          ▼
     Transferência
          │
          ├── débito do remetente
          └── crédito do destinatário
```

## Tecnologias

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Requisitos

- Java 11+
- Maven

## Executando o projeto

Clone o repositório:

```bash
git clone https://github.com/bispobr/Java-spring-plataforma-de-pagamento.git
cd Java-spring-plataforma-de-pagamento
```

Execute a aplicação com Maven:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## API Endpoints

### Realizar transferência

```http
POST /transactions
Content-Type: application/json
```

Exemplo:

```json
{
  "valor": 100.00,
  "remetenteId": 1,
  "destinatarioId": 2
}
```

### Listar usuários

```http
GET /users
```

### Cadastrar usuário

```http
POST /users
Content-Type: application/json
```

Exemplo:

```json
{
  "nome": "João da Silva",
  "cpf": "12345678900",
  "saldo": 500.00,
  "email": "joao@example.com",
  "senha": "senha",
  "tipoUsuario": "USUARIO"
}
```

> Os nomes e valores exatos dos campos devem seguir os contratos implementados pela aplicação.

## Banco de Dados

O projeto utiliza **H2 Database** para persistência dos dados.

Por padrão, o banco é utilizado como banco de desenvolvimento e testes da aplicação.

## Testes

Execute os testes com:

```bash
mvn test
```

## Status

Projeto de estudo desenvolvido para praticar desenvolvimento de APIs REST com Spring Boot, persistência com JPA e implementação de regras de negócio relacionadas a uma plataforma de pagamentos.
