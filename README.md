# 🏨 Hotel Management System (Spring Boot)

A **Hotel Management System** built using **Spring Boot, Spring Security, Spring MVC, Thymeleaf, and JPA**.  
This application allows a **receptionist to securely log in** and manage hotel reservations through a **web-based UI**.

The project demonstrates **real-world backend concepts** such as authentication, authorization, MVC architecture, and database interaction.

---

## 🚀 Features

### 🔐 Authentication & Security
- Receptionist login using **Spring Security**
- Session-based authentication
- Secure password storage using **BCrypt**
- Protected routes (CRUD operations accessible only after login)
- Logout support

### 📋 Reservation Management (CRUD)
- View all reservations
- Add new reservations
- Edit existing reservations
- Delete reservations
- Server-side validation through MVC flow

### 🖥️ User Interface
- Built using **Thymeleaf**
- Clean and simple UI for receptionists
- Form-based data entry
- Professional internal-system layout

---

## 🛠️ Tech Stack

- **Java**
- **Spring Boot**
- **Spring Security**
- **Spring MVC**
- **Spring Data JPA / Hibernate**
- **Thymeleaf**
- **MySQL**
- **Maven**
- **HTML / CSS**

---

## 📂 Project Structure

src/main/java/com/github/naveed18/hotelmanagementsystem
├── controller
│   ├── HomeController.java
│   └── ReservationController.java
│  
├── service
│   ├── ReservationServices.java
│   └── ReceptionistUserDetailsService.java
│
├── repository
│   ├── ReservationRepository.java
│   └── ReceptionistRepository.java
│
├── entity
│   ├── ReservationEntity.java
│   └── ReceptionistEntity.java
│
├── config
│   ├── SecurityConfig.java
│   └── PasswordConfig.java
│
└── HotelManagementSystemApplication.java


---

## 🗄️ Database Design

### `receptionists`
|  Column  |          Type             |
|----------|---------------------------|
| id       | BIGINT (PK)               |
| email    | VARCHAR (UNIQUE)          |
| password | VARCHAR (BCrypt encoded)  |

### `reservations_mvc`
|     Column     |     Type    |
|----------------|-------------|
| reservation_id | BIGINT (PK) | 
|  guest_name    | VARCHAR     |
|   room_number  | INT         |
|  phone_number  | VARCHAR     |

---

## 🔑 Default Login Credentials (Development)

> These credentials are automatically created on application startup for development/testing.

Email: admin@hotel.com

Password: admin123



⚠️ **Note:**  
This is for development only. In real systems, receptionist accounts are created by administrators.

---

## 🌐 Application Flow

1. User tries to access `/reservations`
2. Spring Security redirects to login page
3. Receptionist logs in
4. Session is created
5. User gains access to:
   - Dashboard
   - Reservation management pages

---

## ▶️ How to Run the Project

### Prerequisites
- Java 17+
- MySQL
- Maven

### Steps

1. Clone the repository:
```bash
git clone https://github.com/naveed-18/HotelManagementSystem-SpringBoot-CRUD-.git
```

2. Configure database in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Run the application
mvn spring-boot:run


4. Open Browser
http://localhost:8080


### 🧠 Key Learning Outcomes

This project demonstrates:

-> Secure authentication with Spring Security

-> MVC architecture with Thymeleaf

-> roper layering (Controller → Service → Repository)

-> Secure password handling

-> Session management

-> Realistic backend design decisions

### ❌ Why There Is No Public Signup Page

This is an internal hotel management system, not a public application.

-> Receptionists are employees

-> Accounts are created by administrators

-> Public signup would be a security risk

This design reflects real-world enterprise systems.

### 🔮 Future Enhancements

-> Admin role with ability to add receptionists

-> Role-based authorization

-> Input validation & error messages

-> Flash success/error messages

-> Pagination & sorting

-> UI enhancements (Bootstrap)

-> Unit & integration tests