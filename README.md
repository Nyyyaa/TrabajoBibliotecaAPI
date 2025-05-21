# 📚 Biblioteca API

## 📝 Descripción breve

Biblioteca API es una aplicación REST desarrollada con Spring Boot que permite gestionar libros y autores. Permite crear, consultar, actualizar y eliminar libros, así como registrar y obtener autores, manteniendo relaciones entre ambas entidades.

---

# 🚀 Instrucciones para ejecutar la API

# 📚 Endpoints de Libro

Estos son los ejemplospara el Postman:

## 🔹 GET /api/v1/libros (Obtener todos los libros)

GET http://localhost:8080/api/v1/libros

##  GET /api/v1/libros/{id} (Obtener libro por ID)

GET http://localhost:8080/api/v1/libros/1

## 🔹 POST POST /api/v1/libros (Crear un nuevo libro)

POST http://localhost:8080/api/v1/libros

{
  "titulo": "Cien años de soledad",
  "isbn": "1234567890",
  "anioPublicacion": 1967,
  "autor": {
    "id": 1
  }
}

¡Asegurate que primero esté el autor creado!

## 🔹 PUT /api/v1/libros/{id} (Actualizar un libro existente)

PUT http://localhost:8080/api/v1/libros/{id}

{
  "titulo": "Cien años de soledad (Edición revisada)",
  "isbn": "1234567890",
  "anioPublicacion": 1967,
  "autor": {
    "id": 1
  }
}

¡Asegurate que primero esté el autor creado!

## 🔹 DELETE /api/v1/libros/{id} (Eliminar un libro)

DELETE http://localhost:8080/api/v1/libros/1

## 🔎 GET - Buscar libros por título, año, ordenación

GET /api/v1/libros/buscar?titulo=soledad&anio=1967&sortBy=titulo&order=asc

# 🧑‍💼 Endpoints de Autor

## 🔹 GET /api/v1/autores (Obtener todos los autores)

GET http://localhost:8080/api/v1/autores

## 🔹 GET /api/v1/autores/{id} (Obtener autor por id)

GET http://localhost:8080/api/v1/autores/1

## 🔹 POST /api/v1/autores (Crear un nuevo autor y con sus libros)

POST http://localhost:8080/api/v1/autores

{
  "nombre": "Gabriel García Márquez",
  "nacionalidad": "Colombiana",
  "libros": [
    {
      "titulo": "Cien años de soledad",
      "isbn": "1234567890",
      "anioPublicacion": 1967
    },
    {
      "titulo": "El coronel no tiene quien le escriba",
      "isbn": "9876543210",
      "anioPublicacion": 1961
    }
  ]
}
