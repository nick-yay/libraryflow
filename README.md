# LibraryFlow - API de Biblioteca
### API REST simples para gerenciar livros e autores com Spring Boot + H2.

## Como rodar

bash
mvn spring-boot:run
Roda em http://localhost:8080

H2 Console: http://localhost:8080/h2-console
(JDBC: jdbc:h2:file:C:/temp/libraryflow, user: sa)

## Endpoints

### Autores
text
POST  /authors    → cria autor
GET   /authors    → lista todos
GET   /authors/ID → autor + livros dele
PUT   /authors/ID → atualiza
DELETE /authors/ID → deleta (com cascade)

### Livros
POST  /books → criar livro
GET   /books → listar todos
GET   /books/1 → livro específico
PUT   /books/1 → atualizar
DELETE /books/1 → deletar

## Teste rápido (Postman)

### 1. Criar autor:

json
POST /authors
{
  "name": "J.K. Rowling",
  "nationality": "Britânica", 
  "biography": "Harry Potter"
}
(Pegar o Id)

### 2. Criar livro:

json
POST /books
{
  "title": "Harry Potter e a Pedra Filosofal",
  "isbn": "9788533615556",
  "publicationYear": 1997,
  "authorId": Id
}
### 3. Testar:

GET /books → mostra os livros
GET /authors/Id → mostra Rowling com seus livros

### Stack

- Spring Boot 3.0.3
- Java 21
- H2 Database
- JPA/Hibernate
- Maven
- Lombok

## Estrutura

src/main/java/com/libraryflow/libraryflow/
├── controller/
├── service/
├── model/     ← Author.java, Book.java
├── repository/
└── DTO/

## Funcionalidades

- CRUD completo
- Relacionamento Author ↔ Books
- Cascade delete
- DTOs
- Validação

## Autor:
Nicolas Ludugerio - São Paulo/SP
nicolasludugerio@gmail.com

