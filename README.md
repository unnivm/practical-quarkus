# Practical Quarkus: From Zero to Native

[![GitHub stars](https://img.shields.io/github/stars/unnivm/practical-quarkus)](https://github.com/unnivm/practical-quarkus/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/unnivm/practical-quarkus)](https://github.com/unnivm/practical-quarkus/forks)
[![Java Version](https://img.shields.io/badge/Java-21-blue.svg)](https://adoptium.net/)
[![Quarkus Version](https://img.shields.io/badge/Quarkus-3.35.3-blue)](https://quarkus.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)


This repository contains the complete, working code examples for the book **"Practical Quarkus: From Zero to Native"**. Every example is tested and ready to run.

**What you can build:**
* A REST API with a PostgreSQL database using Panache (CRUD in 20 lines)
* A complete test suite (unit + integration)
* A native executable that starts in ~0.05 seconds

---
## 📖 Get the Book
**Practical Quarkus: From Zero to Native** is available on Amazon. The book covers everything in this repository and much more, including testing, native executables, and REST clients.

[👉 Buy on Amazon Now](https://www.amazon.com/dp/B0H2JR9DLD)

## 🎁 Get the Free Survival Guide
Struggling with Quarkus native image builds? Download the free **"Quarkus Native Image Survival Guide"** PDF, which covers 5 common startup failures and their fixes.

[📥 Download the Free PDF](quarkus-native-survival-guide.pdf)

---

## 🚀 Run the Code in 60 Seconds

**Prerequisites:** Java 21, Maven, Docker (for the database).

**1. Clone the repo**
```
git clone https://github.com/unnivm/practical-quarkus.git
cd practical-quarkus# practical-quarkus
```
**2. Start the database**
```
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=devdb -p 5432:5432 -d postgres
```
**3. Run in development mode**
```
./mvnw quarkus:dev
```
The API will be available at http://localhost:8080/users.

## 📚 Code by Chapter
| Chapter | Topic | Code Location | What You'll Learn |
| :--- | :--- | :--- | :--- |
| 2 | CRUD with Panache | `src/main/java/org/example/User.java` | Build a REST API with a PostgreSQL database in 20 lines. |
| 3 | Validation & Error Handling | `UserResource.java` | Add validation and proper HTTP error handling. |
| 7 | Native Executable | `application.properties` | Compile your app to a native executable that starts in 0.01s. |

🤝 Contributing
Found an issue? Have an improvement? Please open an issue or submit a pull request

