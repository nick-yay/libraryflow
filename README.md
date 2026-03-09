LibraryFlow - API de Biblioteca
API REST simples para gerenciar livros e autores com Spring Boot + H2.

Como rodar
bash
mvn spring-boot:run
Roda em http://localhost:8080

H2 Console: http://localhost:8080/h2-console
(JDBC: jdbc:h2:file:C:/temp/libraryflow, user: sa)

Endpoints
Autores
text
POST  /authors    → cria autor
GET   /authors    → lista todos
GET   /authors/129 → autor + livros dele
PUT   /authors/129 → atualiza
DELETE /authors/129 → deleta (com cascade)
Livros
text
POST  /books → cria livro
GET   /books → lista todos
GET   /books/1 → livro específico
PUT   /books/1 → atualiza
DELETE /books/1 → deleta
Teste rápido (Postman)
1. Cria autor:

json
POST /authors
{
  "name": "J.K. Rowling",
  "nationality": "Britânica", 
  "biography": "Harry Potter"
}
(Pega o ID=129)

2. Cria livro:

json
POST /books
{
  "title": "Harry Potter e a Pedra Filosofal",
  "isbn": "9788533615556",
  "publicationYear": 1997,
  "authorId": 129
}
3. Testa:

text
GET /books → vê os livros
GET /authors/129 → vê Rowling com livros
Tech Stack
Spring Boot 3.0.3

Java 21

H2 Database

JPA/Hibernate

Maven

Lombok

Estrutura
text
src/main/java/com/libraryflow/libraryflow/
├── controller/
├── service/
├── model/     ← Author.java, Book.java
├── repository/
└── DTO/
Funcionalidades
CRUD completo

Relacionamento Author ↔ Books

Cascade delete

DTOs

Validação

Autor
Nicolas Ludugerio - São Paulo/SP
nicolasludugerio@gmail.com

