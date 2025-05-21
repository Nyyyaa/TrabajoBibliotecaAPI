# 📚 Biblioteca API

## 📝 Descripción breve

Biblioteca API es una aplicación REST desarrollada con Spring Boot que permite gestionar libros y autores. Permite crear, consultar, actualizar y eliminar libros, así como registrar y obtener autores, manteniendo relaciones entre ambas entidades.

---

# 🚀 Instrucciones para ejecutar la API

(Se aconseja priemro hacer los endpoint de Autor y luego los de Libro para que vaya todo correcto)

# 🧑‍💼 Endpoints de Autor

## 🔹 GET /api/v1/autores (Obtener todos los autores)

GET http://localhost:8080/api/v1/autores

## 🔹 GET /api/v1/autores/{id} (Obtener autor por id)

GET http://localhost:8080/api/v1/autores/1

## 🔹 POST /api/v1/autores (Crear un nuevo autor y con sus libros)

POST http://localhost:8080/api/v1/autores

![image](https://github.com/user-attachments/assets/113e7e8b-95b8-45c6-8cf9-2a842c37ba48)

# 📚 Endpoints de Libro

Estos son los ejemplos para el Postman:

## 🔹 GET /api/v1/libros (Obtener todos los libros)

GET http://localhost:8080/api/v1/libros

## 🔹 GET /api/v1/libros/{id} (Obtener libro por ID)

GET http://localhost:8080/api/v1/libros/1

## 🔹 POST /api/v1/libros (Crear un nuevo libro)

POST http://localhost:8080/api/v1/libros

![image](https://github.com/user-attachments/assets/b04a4a21-c8f4-4f9e-85d5-fc97184336ec)

¡Asegurate que primero esté el autor creado!

## 🔹 PUT /api/v1/libros/{id} (Actualizar un libro existente)

PUT http://localhost:8080/api/v1/libros/{id}

![image](https://github.com/user-attachments/assets/ccc38805-e62a-4657-aebe-334bc053cbb3)

¡Asegurate que primero esté el autor creado!

## 🔹 DELETE /api/v1/libros/{id} (Eliminar un libro)

DELETE http://localhost:8080/api/v1/libros/1

## 🔎 GET - Buscar libros por título, año, ordenación

GET /api/v1/libros/buscar?titulo=soledad&anio=1967&sortBy=titulo&order=asc

---

# 📦 Estructura del Proyecto

com.tuapp.bibliotecaapi
├── controller
│   ├── LibroController.java
│   └── AutorController.java
├── model
│   ├── Libro.java
│   └── Autor.java
├── repository
│   ├── LibroRepository.java
│   └── AutorRepository.java
├── service
│   ├── LibroService.java
│   └── AutorService.java
└── BibliotecaApiApplication.java

# 🧑‍💻 Autores
Desarrollado por Yanira Gutierrez y Eduardo Ortega.
