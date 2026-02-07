# PetCare_Sheduler 🐾

A simple Java console application to register pets and manage their appointments (vet visit, vaccination, grooming, etc.).  
Includes saving/loading data using Java Serialization and appointment status tracking (Upcoming / Due Today / Overdue / Done).

---

## Features

### Pet Management
- Register a pet with:
  - Pet ID
  - Name, Breed, Age
  - Owner name + contact info
  - Auto registered date

### Appointment Management
- Add appointments to a pet
- Each appointment has:
  - Appointment type
  - Notes
  - Date
  - Unique ID (UUID) *(shown as short 8-char ID for easy selection)*
- View appointment status:
  - `UPCOMING`
  - `DUE_TODAY`
  - `OVERDUE`
  - `DONE`
- Mark an appointment as DONE using short UUID

### Filters / Searching
- Display all records
- View only:
  - Upcoming appointments
  - Today’s appointments
  - Past/Overdue appointments
- Search pet details by pet name

### Data Persistence
- Save all pets & appointments to a file (`pet.ser`)
- Load data automatically on program start

---

## Tech Stack
- Java (Console application)
- Java Collections (`HashMap`, `ArrayList`)
- Java Time API (`LocalDate`)
- Java Serialization (`ObjectOutputStream`, `ObjectInputStream`)
- UUID for unique appointment IDs

---

## How to Run

### Option 1: Run in NetBeans
1. Open the project in NetBeans
2. Run the project
3. Use the console menu to interact

### Option 2: Run with Maven (if configured)
```bash
mvn clean package
mvn exec:java
