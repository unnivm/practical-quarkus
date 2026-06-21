# Practical Quarkus: From Zero to Native

[![Java Version](https://img.shields.io/badge/Java-21-blue.svg)](https://adoptium.net/)
[![Quarkus Version](https://img.shields.io/badge/Quarkus-3.35.3-blue)](https://quarkus.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

This repository contains the complete, working code examples for the book **"Practical Quarkus: From Zero to Native"**. Every example is tested and ready to run.

**What you can build:**
* A REST API with a PostgreSQL database using Panache (CRUD in 20 lines)
* A complete test suite (unit + integration)
* A native executable that starts in ~0.05 seconds

**Read the full book on Amazon:** [Practical Quarkus: From Zero to Native](https://www.amazon.com/dp/B0H2JR9DLD)

**Quarkus native survival guide:** [Download from Here](quarkus-native-survival-guide.pdf)

---

## 🚀 Run the Code in 60 Seconds

**Prerequisites:** Java 21, Maven, Docker (for the database).

**1. Clone the repo**
```
git clone https://github.com/unnivm/practical-quarkus.git
cd practical-quarkus# practical-quarkus

**2. Start the database**
```
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=devdb -p 5432:5432 -d postgres

**3. Run in development mode**
```
./mvnw quarkus:dev

The API will be available at http://localhost:8080/users.

📚 Code by Chapter
Chapter	  Topic	                        Code Location
2	      CRUD with Panache	            src/main/java/org/example/User.java
3	      Validation & Error Handling	UserResource.java
7	      Native Executable	            application.properties and build config

🤝 Contributing
Found an issue? Have an improvement? Please open an issue or submit a pull request

