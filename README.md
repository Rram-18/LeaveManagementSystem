# 📝 Leave Management System

This is a **Spring Boot project** that allows users to apply for leave and admin to approve it.

---

## 🔑 Features

- User & Admin Login (with JWT Token)
- Apply for Leave
- Admin Approves Leave
- H2 In-Memory Database
- Sends Email after Approval

---

## 💻 Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- Gmail SMTP (JavaMailSender)
- JWT Authentication

---

## 🚀 How to Run the Project

1. Clone the repo:

git clone https://github.com/Rram-18/LeaveManagementSystem.git


2. Open the project in IntelliJ

3. Go to `application.properties` and change:

spring.mail.username=your_email@gmail.com
spring.mail.password=your_gmail_app_password


4. Run the project

5. Test using Postman:
    - **Login**: `POST /login`
    - **Apply Leave**: `POST /leave/apply`
    - **Approve Leave**: `POST /leave/approve/{id}`
    - **View Leaves**: `GET /leave/mine`

---

## 🧑‍💼 Default Users (for testing)

You can insert users from H2 Console or directly in Java code.

---

## 🧠 Author

- Ram Naresh Dubey
- Java Developer | Spring Boot Enthusiast
