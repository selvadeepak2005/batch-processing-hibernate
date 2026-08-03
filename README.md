# Batch Processing Hibernate

A console-based Java application developed using **Hibernate ORM** to demonstrate **Batch Processing** techniques for efficiently inserting, updating, and deleting large numbers of records.

## 📌 Features

- Batch Insert Employees
- Batch Update Employees
- Batch Delete Employees
- Batch Commit
- Rollback Verification
- Memory Optimization using `flush()` and `clear()`

## 🛠️ Technologies Used

- Java 17
- Hibernate ORM 6
- MySQL
- Maven
- IntelliJ IDEA

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.selva
│   │       ├── Dao
│   │       ├── Entity
│   │       ├── Util
│   │       └── Main.java
│   └── resources
│       └── hibernate.cfg.xml
```

## ⚙️ Functional Requirements

- Batch Insert
- Batch Update
- Batch Delete

## 🧪 Submission Test Cases

- Insert 10,000 Records
- Memory Utilization
- Batch Commit
- Rollback Verification

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/<YOUR_USERNAME>/batch-processing-hibernate.git
```

### 2. Create Database

```sql
CREATE DATABASE batch_processing_db;
```

### 3. Configure Database

Update your MySQL username and password in:

```
src/main/resources/hibernate.cfg.xml
```

### 4. Build the Project

```bash
mvn clean compile
```

### 5. Run the Application

```bash
mvn exec:java -Dexec.mainClass="com.selva.Main"
```

## 📷 Console Menu

```
====================================
      Batch Processing System
====================================

1. Batch Insert Employees
2. Batch Update Employees
3. Batch Delete Employees
4. Exit
```

## 📚 Concepts Covered

- Hibernate SessionFactory
- Hibernate Session
- Transactions
- Batch Processing
- flush()
- clear()
- Rollback
- Commit
- Memory Optimization
- HQL

## 👨‍💻 Author

**Selva Deepak**

- BE Electronics and Communication Engineering
- Java Full Stack Developer
