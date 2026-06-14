\# Learning Hibernate



A hands-on repository documenting my journey of learning Hibernate and JPA in Java. This project contains practical examples covering entity mapping, relationships, fetching strategies, caching, and database operations.



\## 🚀 Technologies Used



\* Java

\* Hibernate ORM

\* JPA (Java Persistence API)

\* Maven

\* MySQL

\* IntelliJ IDEA



\---



\## 📚 Topics Covered



\### 1. Basic Entity Mapping



\* Creating entities using annotations

\* Mapping Java classes to database tables

\* Primary key generation



\### 2. CRUD Operations



\* Insert records

\* Fetch records

\* Update records

\* Delete records



\### 3. One-to-One Mapping



Implementation and examples of one-to-one relationships.



\*\*Files\*\*



\* `Alien.java`

\* `Laptop.java`

\* `AlienMain.java`

\* `LaptopMain.java`



\---



\### 4. One-to-Many \& Many-to-One Mapping



Understanding parent-child relationships between entities.



\*\*Resources\*\*



\* `OneToMany And ManyToOne.png`



\---



\### 5. Many-to-Many Mapping



Examples demonstrating many-to-many relationships and join tables.



\*\*Resources\*\*



\* `ManyToMany.png`



\---



\### 6. Fetch Strategies



Comparison of:



\* Lazy Loading

\* Eager Loading



\*\*Files\*\*



\* `LazingLoading\_EagerLoading.java`



\---



\### 7. Hibernate Caching



Understanding Hibernate's caching mechanisms.



Topics:



\* First-Level Cache

\* Second-Level Cache



\*\*Files\*\*



\* `Level2Cache.java`



\---



\## 📂 Project Structure



```text

src/

├── main/

│   ├── java/

│   │   └── com/deku/

│   │       ├── Alien.java

│   │       ├── AlienMain.java

│   │       ├── Laptop.java

│   │       ├── LaptopMain.java

│   │       ├── Students.java

│   │       ├── StudentMain.java

│   │       ├── Level2Cache.java

│   │       └── MappingRelations/

│   │           ├── ManyToMany.png

│   │           ├── OneToMany And ManyToOne.png

│   │           └── OneToOne.png

│   └── resources/

```



\---



\## 🎯 Purpose



This repository serves as my personal learning workspace for mastering Hibernate and understanding how Java applications interact with relational databases using ORM concepts.



\## 📝 Notes



This project is intended for educational purposes and may contain multiple experimental implementations while exploring Hibernate features.



