# Student Management System

A beginner-friendly Java console application for managing student records.

## Features

* Add new students
* View all student records
* Search students by ID
* Update student details
* Delete student records
* Automatically calculate grades
* Save records to a local file
* Load saved records when the application restarts
* Validate user input and prevent duplicate student IDs

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* File Handling
* Exception Handling

## Project Structure

```text
Student_managment/
├── src/
│   ├── Main.java
│   ├── Student.java
│   └── StudentManager.java
├── data/
│   └── students.txt
├── .gitignore
└── README.md
```

## Requirements

* JDK 21 or a compatible newer JDK
* Visual Studio Code or another Java IDE

## How to Run

Open the terminal in the project root directory.

Compile the Java files:

```bash
javac -d out src/Main.java src/Student.java src/StudentManager.java
```

Run the application:

```bash
java -cp out Main
```

## Grade System

| Marks    | Grade |
| -------- | ----- |
| 90–100   | A+    |
| 80–89.99 | A     |
| 70–79.99 | B     |
| 60–69.99 | C     |
| 40–59.99 | D     |
| Below 40 | F     |

## Data Storage

Student records are stored locally in `data/students.txt`. The application loads saved records when it starts.

## Author

Developed as a Java learning project.
