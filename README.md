# Product and Category Management System

This is a Spring Boot application designed for managing products and categories. It leverages JPA and Hibernate for database operations and supports CRUD functionalities for both entities.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Error Handling](#error-handling)
- [Contact](#contact)

## Introduction

This application provides a backend for managing products and categories with a relational database. It supports creating, reading, updating, and deleting (CRUD) operations for both entities and includes server-side pagination for listing products.

## Prerequisites

Ensure you have the following installed before you start:

- **Java 8 or later**
- **Maven**
- **MySQL**

## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/repository-name.git
   cd repository-name
**2. Create the MySQL database:**

  CREATE DATABASE prodcat;


##  Configuration


  1. Open the application.properties file in src/main/resources/.

  2. Set your MySQL database credentials:

       spring.datasource.url=jdbc:mysql://localhost:3306/prodcat
       spring.datasource.username=your-username
       spring.datasource.password=your-password
       spring.jpa.hibernate.ddl-auto=update
       spring.jpa.show-sql=true
Replace your-username and your-password with your MySQL credentials.

## Running the Application
   You can run the application using Maven:
     - mvn spring-boot:run
      
   Alternatively, you can build the JAR file and run it:
     -  mvn clean install
     - java -jar target/NimapTaskApplication.jar

## API Endpoints

  **Category Endpoints**
  
# Get Category by ID:

GET /categories/{id}
Response: JSON object of the category

# Create Category:

POST /categories
Request body: JSON object of the category
Response: JSON object of the created category

# Update Category:

PUT /categories/{id}
Request body: JSON object of the category
Response: JSON object of the updated category

# Delete Category:

DELETE /categories/{id}
Response: HTTP 200 OK or 404 if not found

**Product Endpoints**

# Get Product by ID:

GET /products/{id}
Response: JSON object of the product

# Create Product:

POST /products
Request body: JSON object of the product
Response: JSON object of the created product

# Update Product:

PUT /products/{id}
Request body: JSON object of the product
Response: JSON object of the updated product

# Delete Product:

DELETE /products/{id}
Response: HTTP 200 OK or 404 if not found


**Get Products with Pagination:**

GET /products?page={page}&size={size}
Response: JSON array of products

## Error Handling

The application uses a custom Messages class for error messaging. Ensure the Messages.java file is properly set up to handle cases like:

    - Category/Product Not Found
    - Database Connection Issues
    - Invalid Input Data

  
