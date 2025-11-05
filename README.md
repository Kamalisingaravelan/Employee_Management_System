# Employee_Management_System
A Spring Boot-based **Employee Management System** that simplifies managing employee and department data. It provides secure **RESTful APIs** for performing CRUD operations, integrates Spring Security for authentication, and uses JPA for seamless interaction with the MySQL database.

## Project Overview
The Employee Management System is a Spring Boot-based backend application developed to efficiently manage employee and department records within an organization. Built using the Spring Boot framework, this project demonstrates a clean MVC architecture with layers for controllers, services, repositories, and models. The application exposes RESTful APIs for seamless communication with client applications and leverages Spring Data JPA for efficient interaction with the MySQL database.

## Project Structure
<img width="364" height="757" alt="image" src="https://github.com/user-attachments/assets/2e58bde0-788d-4664-8af6-3f95c225a21c" />

## Features
**Employee Module**
This module manages all employee-related operations within the system.
**Uses:**
- Add, update, delete, and view employee details.
- Assign employees to specific departments.
- View individual employee profiles using Employee ID.
**Technical Flow:**
- Handled through REST APIs mapped under /employees. The data is processed by the EmployeeService and persisted using JPA repositories.

 **Department Module**
This module manages departmental operations and acts as a parent entity for employees.
**Uses:**
- Create, update, or remove department records.
- Retrieve department-wise employee lists.
- Manage department head assignments.
**Technical Flow:**
- Controllers interact with DepartmentService, which uses DepartmentRepository to manage relational data with employees.

**Exception**
**Purpose:** Handles application-wide exceptions in a unified way.
ResourceNotFoundException.java – A custom exception thrown when an entity (like an employee or department) is not found in the database.
GlobalExceptionHandler.java – Uses @ControllerAdvice to globally handle all exceptions and return proper HTTP error responses.
This ensures the application is user-friendly and prevents system crashes from unhandled errors.

**DTO(Data Transfer Object)**
**Purpose:** Used for Data Transfer Objects (DTOs) to carry data between layers without exposing internal models.
EmployeeDTO.java – Transfers employee data between client and server.
DepartmentDTO.java – Transfers department data between API and service layer.
DTOs improve security and maintainability by decoupling the entity layer from external exposure.

## Project Workflow
**Client Request** → Sent via HTTP (to Controller):
The client (such as **Postman**) sends an **HTTP request** (GET, POST, PUT, or DELETE) to interact with the system’s RESTful APIs.
**Controller Layer** → Validates request and delegates to Service layer:
The controller **receives the request, validates input data, maps it to appropriate DTOs**, and forwards it to the corresponding service method for processing.
**Service Layer** → Processes business logic:
This layer contains the **core business rules**, It performs data transformations, applies validations, and coordinates between the controller and repository layers to ensure proper data flow.
**Repository Layer** → Interacts with the database through JPA:
The repository layer communicates directly with the **database using Spring Data JPA, executing CRUD operations** and returning entity data to the service layer.
**Response** → Data is returned to the client through Controller as a REST API response:
Once processing is complete, the controller sends a structured **HTTP response** (usually in JSON format) back to the client, confirming the operation result or returning requested data.

## Technology Stack
| **Category**         | **Technology / Tool Used**  | **Description**                                                   |
| -------------------- | --------------------------- | ----------------------------------------------------------------- |
| **Language**         | Java 17                     | Core programming language used to build the application           |
| **Framework**        | Spring Boot 3.x             | Main framework used for backend development and REST API creation |
| **Security**         | Spring Security             | Provides authentication, authorization, and endpoint protection   |
| **ORM Framework**    | Spring Data JPA (Hibernate) | Simplifies database operations and entity mapping                 |
| **Database**         | MySQL                       | Stores employee and department data persistently                  |
| **API Testing Tool** | Postman                     | Used to test, validate, and debug REST API endpoints              |


## Project Images

### ERDiagram
<img width="438" height="580" alt="image" src="https://github.com/user-attachments/assets/fc078c8b-aa17-41d8-a8d3-412088d100dd" />

### Sample Input&Outputs
<img width="795" height="202" alt="image" src="https://github.com/user-attachments/assets/20b6c11d-2c14-43c5-8353-87efb6edef5d" />
<img width="798" height="674" alt="image" src="https://github.com/user-attachments/assets/9d501499-959a-4055-9e02-a8435abcb088" /><img width="768" height="498" alt="image" src="https://github.com/user-attachments/assets/34cc434b-13ce-4a50-8680-f14b00e5f720" /><img width="761" height="568" alt="image" src="https://github.com/user-attachments/assets/fc5b106e-0fc8-4e0b-89c6-977c86c864f8" /><img width="748" height="322" alt="image" src="https://github.com/user-attachments/assets/b8fa719b-2b38-4d9c-8c84-1bf51ab5cc0d" />

## Future Enhancements
To make the Employee Management System more robust, user-friendly, and enterprise-ready, the following features can be added in the future:
- Implement advanced authentication and authorization for Admin
- Develop an interactive frontend using React.js or Angular 
- Automatically send alerts for new employee registration department changes.
- Integrate data visualization tools to display employee performance, department strength, and salary insights through interactive charts.
- Enable profile picture uploads and document management for employee records.

## Conclusion
The Employee Management System demonstrates the power and flexibility of the Spring Boot framework in developing secure, scalable, and maintainable enterprise applications. By combining Spring Security, JPA, and MySQL, the project ensures efficient data handling, modular architecture, and secure user interactions.

**Author**

**Kamali Singaravelan**


