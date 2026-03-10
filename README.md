# LibraryFlow - API de Biblioteca
### API REST para gerenciar livros e autores com Spring Boot + PostgreSQL.

## Como rodar

### Com Docker (recomendado)
Pré-requisito: ter o [Docker Desktop](https://www.docker.com/products/docker-desktop) instalado.
```bash
# 1. Gerar o .jar
./mvnw clean package -DskipTests

# 2. Subir a aplicação e o banco
docker-compose up --build
```

API rodando em http://localhost:8080

### Parar a aplicação
```bash
docker-compose down
```

---

## Endpoints

### Autores
```
POST   /authors     → cria autor
GET    /authors     → lista todos
GET    /authors/ID  → autor + livros dele
PUT    /authors/ID  → atualiza
DELETE /authors/ID  → deleta (com cascade)
```

### Livros
```
POST   /books     → criar livro
GET    /books     → listar todos
GET    /books/ID  → livro específico
PUT    /books/ID  → atualizar
DELETE /books/ID  → deletar
```

---

## Teste rápido (Postman)

### 1. Criar autor:
```json
POST /authors
{
  "name": "J.K. Rowling",
  "nationality": "Britânica",
  "biography": "Harry Potter"
}
```

### 2. Criar livro:
```json
POST /books
{
  "title": "Harry Potter e a Pedra Filosofal",
  "isbn": "9788533615556",
  "publicationYear": 1997,
  "authorId": 1
}
```

### 3. Testar:
```
GET /books       → mostra os livros
GET /authors/ID  → mostra o autor com seus livros
```

---

## Stack
- Java 21
- Spring Boot 3.x
- PostgreSQL 16
- Spring Data JPA / Hibernate
- Lombok
- Docker / Docker Compose
- Maven

---

## Estrutura
```
src/main/java/com/libraryflow/libraryflow/
├── controller/
├── service/
├── model/        ← Author.java, Book.java
├── repository/
└── DTO/
```

---

## Funcionalidades
- CRUD completo de Autores e Livros
- Relacionamento Author ↔ Books (One-to-Many)
- Cascade delete
- DTOs
- Validação de dados
- Containerização com Docker

---

## Autor
Nicolas Ludugerio — São Paulo/SP  
nicolasludugerio@gmail.com
