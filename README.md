# Practical Quarkus: From Zero to Native

[![Java Version](https://img.shields.io/badge/Java-21-blue.svg)](https://adoptium.net/)
[![Quarkus Version](https://img.shields.io/badge/Quarkus-3.35.3-blue)](https://quarkus.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

This repository contains the complete, working code examples for the book **"Practical Quarkus: From Zero to Native"**. Every example is tested and ready to run.

**What you can build:**
* A REST API with a PostgreSQL database using Panache (CRUD in 20 lines)
* A complete test suite (unit + integration)
* A native executable that starts in ~0.05 seconds

**Read the full book on Amazon:** [Practical Quarkus: From Zero to Native](YOUR_AMAZON_LINK)

**Or get a free chapter:** [Download Chapter 1 PDF](YOUR_SYSTEME_IO_LINK)

---

## 🚀 Run the Code in 60 Seconds

**Prerequisites:** Java 21, Maven, Docker (for the database).

**1. Clone the repo**
```bash
git clone https://github.com/unnivm/practical-quarkus.git
cd practical-quarkus# practical-quarkus

**2. Start the database**
```bash
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=devdb -p 5432:5432 -d postgres

**3. Run in development mode**
```bash
./mvnw quarkus:dev

The API will be available at http://localhost:8080/users.

📚 Code by Chapter
Chapter	  Topic	                        Code Location
2	      CRUD with Panache	            src/main/java/org/example/User.java
3	      Validation & Error Handling	UserResource.java
7	      Native Executable	            application.properties and build config

🤝 Contributing
Found an issue? Have an improvement? Please open an issue or submit a pull request


**Why this works:** It offers instant value (the 60-second setup) and gives clear pathways to both your **paid product** (the book) and your **lead magnet** (the free chapter).

---

### 📢 2. Announce Your Repo Where Quarkus Devs Gather

You need to go where your target audience already is and share your work as a resource, not an ad.

*   **Dev.to and Medium**: You are already writing articles here[citation:8]. This is your most effective channel. At the end of every single article, add a call-to-action (CTA) like this:

    > *"The complete, working code for all the examples in this article is available on GitHub: [Link to your repo]"*

*   **Reddit**: Subreddits like `r/quarkus`, `r/java`, and `r/microservices` are filled with your exact audience. Post a link to your repository with a short, honest title: *"I wrote a book on Quarkus, and here's the complete codebase for it. Hope it's helpful."*

*   **Twitter/X and LinkedIn**: Don't just post a link. Post a specific tip or a line of code from your repo and *then* the link.

    > *Example LinkedIn post: "One of the trickiest parts of Quarkus native images is registration for reflection. Here's how I solved it. The full code is in my repo: [Link]"* [citation:9]

---

### 🌟 3. Optimize Your Repo for Discovery (SEO)

GitHub itself is a search engine[citation:2][citation:4]. Make it easy for people to find you.

*   **Repository Name**: Keep it as `practical-quarkus`. It's clear and keyword-rich.
*   **Description**: This is critical. Write a short, punchy sentence that appears in search results. Use the keywords you want to be found for.
    *   **Good:** "Complete code for 'Practical Quarkus: From Zero to Native' - REST APIs, Panache, native executables, and testing."
    *   **Even Better:** Add a **topic tag** to your repo. In the "About" section on GitHub, add the tags: `quarkus`, `java`, `graalvm`, `native-image`, `microservices`[citation:2]. This is how people find you when they browse topics.

---

### 🔗 4. Turn Your Book into a Traffic Driver

Your book is already in the hands of some readers. Use it to send them back to your GitHub repo.

*   **In the Book**: In your introduction or first chapter, add a line: *"All the code for this book is available on GitHub. You can find it at `https://github.com/YOUR_USERNAME/practical-quarkus`."*
*   **In Your "Reader Magnet" PDF**: The free PDF you are creating (the Quarkus survival guide) is a perfect place to add a link to the complete code on GitHub.

This creates a virtuous circle: **Medium Article → GitHub Repo → Free PDF → Email List → Book Sale.**

---

### ✅ Your Action Plan for This Week

| Task | Time | Impact |
| :--- | :--- | :--- |
| **1. Rewrite your `README.md`** using the template above, focusing on the 60-second "run it" section. | 1 hour | **High** - This is your main landing page. |
| **2. Add links** from your Medium articles and your free PDF back to the GitHub repo. | 30 minutes | High - Directs existing traffic to your repo. |
| **3. Share your repo** on Reddit (`r/quarkus`) and LinkedIn with a specific tip. | 30 minutes | Medium - Gets the repo in front of new eyes. |
| **4. Add topic tags** (`quarkus`, `java`, `graalvm`) to your repo's "About" section. | 2 minutes | Low - Improves discoverability within GitHub. |

Your GitHub repo is not just a place to store code. It is the central hub that connects your free content, your lead magnet, and your paid book. By making it clean, welcoming, and useful, you turn a visitor into a user, and a user into a potential customer.

