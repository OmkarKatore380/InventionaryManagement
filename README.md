This is a simple Inventory Management project built using Spring Boot, H2 Database, and REST APIs.
It supports creating items, updating items, deleting items, pagination, and filtering by price.

Features

Create Item

Get All Items

Pagination Support

Filter Items by Price

Update Item

Delete Item

Uses H2 In-Memory Database (no installation needed)

Tech Stack

Java 17

Spring Boot

Spring Data JPA

H2 Database

ModelMapper

How to Run

Clone the project

Open in IntelliJ/VS Code

Run the Spring Boot application

Access H2 Console:

http://localhost:8080/h2-console

API Endpoints
Create Item

POST /items/create

{
  "name": "Car",
  "description": "A fast car",
  "price": 30000
}

Pagination

POST /items/page

{
  "page": 0,
  "size": 5,
  "sortBy": "id"
}

Filter by Price

POST /items/filter

{
  "minPrice": 10000,
  "maxPrice": 50000,
  "page": 0,
  "size": 5,
  "sortBy": "price"
}

Update Item

PUT /items/update/{id}

Delete Item

DELETE /items/delete/{id}

H2 Database

Enabled by default.
No setup required.
