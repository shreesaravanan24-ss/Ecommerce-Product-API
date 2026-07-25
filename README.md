#  E-Commerce Product API

A Spring Boot REST API for managing products and categories in an e-commerce system. This project demonstrates CRUD operations using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

##  Features

- Manage Categories
- Manage Products
- Create, Read, Update and Delete (CRUD)
- RESTful API Architecture
- MySQL Database Integration
- Spring Data JPA & Hibernate
- Layered Architecture

##  Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- IntelliJ IDEA

##  Project Structure

```
src
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
│   └── impl
├── config
├── util
└── EcommerceProductApiApplication.java
```

## ️ Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

## ️ Running the Project

1. Clone the repository.
2. Create the `ecommerce_db` database in MySQL.
3. Update the database credentials in `application.properties`.
4. Run the Spring Boot application.
5. Test the REST APIs using Postman or another API client.

##  Future Enhancements

- JWT Authentication
- Swagger/OpenAPI Documentation
- Pagination & Sorting
- Product Search
- Image Upload
- Order Management
- Shopping Cart
- Payment Integration

##  Author

**Shree Saravanan B**

B.Tech Artificial Intelligence and Data Science

Spring Boot Backend Developer

---

If you found this project useful, consider giving it a star.