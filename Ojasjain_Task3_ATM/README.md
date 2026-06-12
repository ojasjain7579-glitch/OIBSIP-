# ATM Interface Project

## 📌 Project Description
This is a simple ATM Interface Project developed using Java, MySQL, HTML, and CSS.

User can:
- Login with Account Number & PIN
- Check Balance
- Deposit Money
- Withdraw Money
- Exit System

---

## 🚀 Technologies Used
- Java
- MySQL
- HTML
- CSS
- Git & GitHub

---

## 🛠 Database Setup

CREATE DATABASE atm_project;

USE atm_project;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    account_no VARCHAR(20),
    name VARCHAR(100),
    pin VARCHAR(10),
    balance DOUBLE
);

INSERT INTO users(account_no,name,pin,balance)
VALUES('1234567890','Anjali','1234',10000);

---

## 👩‍💻 Author
Ojas Jain

