# Hotel Management System – Backend (Spring Boot)

This project is a backend application for a **Hotel Management System** built using **Spring Boot**.  
Currently, it implements the **basic CRUD operations** for managing hotel reservations.  
In future versions, a **login system for receptionists** will be added using Spring Security.


## 🚀 Current Features (Version 1)

- Create a reservation
- View all reservations
- Update an existing reservation
- Delete a reservation
- RESTful APIs tested using Postman
- Clean layered architecture:
  - Controller
  - Service
  - Repository
  - Entity

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- REST APIs
- Maven

## 📂 Project Structure

src/main/java
└── com.github.naveed18.hotelmanagementsystem
├── controller
│   └── ReservationController
├── service
│   └── ReservationServices
├── repository
│   └── ReservationRepository
├── entity
│   └── ReservationEntity
└── HotelManagementSystemApplication

## 🔗 API Endpoints (Current)

| Method |                Endpoint                 |       Description        |
|--------|-----------------------------------------|--------------------------|
|  POST  | `/reservations/reserve-room`            | Create a new reservation |
|  GET   | `/reservations/view-reservations`       | View all reservations    |
|  PUT   | `/reservations/update-reservation/{id}` | Update a reservation     |
| DELETE | `/reservations/delete-reservation/{id}` | Delete a reservation     |


## 📌 Example Request (Create Reservation)

**POST** `/reservations/reserve-room`

```json
{
  "guestName": "Naveed",
  "roomNumber": 101,
  "phoneNumber": "+91 745891247"
}
```

## 🗄️ Database

Database: MySQL

Tables are managed using Hibernate

Database configuration is done via application.properties


## 🎯 Purpose of This Project

This project is built as a learning-focused backend application to:

- Understand Spring Boot fundamentals

- Learn JPA and Hibernate behavior

- Build RESTful CRUD APIs

- Practice real-world backend architecture


## 👤 Author

Naveed
GitHub: https://github.com/naveed-18