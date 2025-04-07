# Java-spring-plataforma-de-pagamento

Este repositório contém um projeto simples desenvolvido em Java Spring, com o objetivo de praticar e aplicar os conceitos dessa tecnologia. O projeto implementa um serviço de pagamento, permitindo transferências monetárias entre usuários. Os usuários são classificados em dois tipos: comuns e lojistas, e ambos possuem carteiras com saldo disponível para transferência. As Regras de negócio sequem os requisitos Abaixo. 
### Requisitos

- Os usuário tem como atributos Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails são
  únicos no sistema;
- Os Usuários podem realizar transferências entre usuários;

- Usuarios Lojistas só recebem transferências;

- Validar se o usuário tem saldo antes da transferência;

## Instalação

1. Clone o repositório:

```bash
git https://github.com/bispobr/Java-spring-plataforma-de-pagamento.git
```

2. Instale as dependências com Maven

## Como Usar

1. Inicie a aplicação com o Maven
2. API está acessível através do Link http://localhost:8080

## API Endpoints

API contém os seguinte endpoint :

```http request
POST /transactions - Realiza uma nova transferência.
Content-Type: application/json

{
  "valor": 000000,
  "remetenteId": 000000,
  "destinatarioId": 000000
}
```

```http request
GET /users - lista todos os usuarios.

```

```http request
POST /users - Cadastra um novo Usuario.
Content-Type: application/json

{
  "nome": "xxxxx",
  "Sobrenome": "xxxxxxx",
  "cpf": "00000000000",
  "saldo": 00,
  "email": "xxxx@xx.xxx",
  "senha": "xxxxxx",
  "tipoUsuario": "USUARIOS"
}
```
## Banco-de-Dados
Esse projeto utiliza o H2 como Banco de Dados.
