# Employee Management System using Java JDBC & MySQL

## Project Overview

This is a console-based Employee Management System developed using Java, JDBC, and MySQL.
The project demonstrates CRUD operations, batch processing, database connectivity, and transaction management using JDBC.

The application allows users to manage employee records through a menu-driven interface.

---

## Features

* Add Employee
* View Employees
* Search Employee by ID
* Update Employee Details
* Delete Employee
* Batch Insert Employees
* Menu-Driven Console Application
* JDBC PreparedStatement Usage
* Batch Processing using executeBatch()
* Transaction Management using commit()

---

## Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE
* Git & GitHub

---

## Database Table Structure

```sql
CREATE TABLE emp(
    id INT PRIMARY KEY,
    name VARCHAR(30),
    salary BIGINT,
    dept VARCHAR(30)
);
```

---

## JDBC Concepts Implemented

* DriverManager
* Connection
* Statement
* PreparedStatement
* ResultSet
* executeQuery()
* executeUpdate()
* Batch Processing
* Transactions
* Exception Handling

---

## Project Structure

```text
src
│
│
└── jdbc.miniproject
       → Employee Management System
```

---

## Sample Operations

1. Add Employee
2. View Employees
3. Search Employee
4. Update Employee
5. Delete Employee
6. Batch Insert
7. Exit

---

## Learning Outcome

This project helped in understanding:

* Java Database Connectivity (JDBC)
* CRUD Operations
* SQL Query Execution
* Prepared Statements
* Batch Processing
* Transaction Management
* Console-Based Application Development

---

## Author

Abhimanyu
B.Tech CSE (AI & ML)
Kuppam Engineering College
