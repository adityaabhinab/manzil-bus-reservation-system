# Manzil Bus - Reservation System

A console-based Java application for managing bus reservations with an interactive seat selection interface.

## Overview

Manzil Bus is designed to demonstrate core **Object-Oriented Programming (OOP)** and **File Handling** concepts in Java. The project tackles the common "blind booking" problem by giving passengers a clear, visual map of the bus layout — letting them choose specific seats (Window/Aisle) before confirming, much like modern booking platforms.

## Features

- **Visual Seat Map:** A dynamic grid showing the bus layout so passengers can instantly spot available seats.
- **Booking Validation:** Prevents duplicate reservations by checking seat availability in real time.
- **Data Persistence:** Bookings and bus records are automatically saved to `.dat` files using Java Serialization — no database needed.
- **Admin Dashboard:** Allows administrators to view the entire bus fleet and a full history of all bookings.

## Technology Stack

**Language:** Java (JDK 17+)

**Concepts Applied:**
- Object-Oriented Programming (Encapsulation, Classes, Objects)
- Collections Framework (`ArrayList`, `List`)
- File I/O (`ObjectOutputStream` for serialized storage)
- Exception Handling

**Tools:** Git, VS Code

## Getting Started

Follow the steps below to run the project locally.

**1. Clone the repository**
```bash
git clone https://github.com/adityaabhinab/Manzil-Bus-Reservation-System.git
```

**2. Compile the source files**

Navigate to the project root (where `src` is located) and run:
```bash
javac src/*.java -d out
```

**3. Launch the application**
```bash
java -cp out Main
```

## Usage Guide

1. **Start the App** — Run the `Main` class to load the main menu.
2. **Book a Ticket** — Select **Option 2** from the menu.
3. **Choose a Bus** — Enter a Bus ID (e.g., `B-101`).
4. **Select a Seat** — The system displays a live seat map:
   - `[ ]` = Available
   - `[X]` = Booked
   - Enter your preferred Row (1–10) and Column (A–D).
5. **Confirm Booking** — Provide passenger details to receive a unique **Ticket ID**.

## Project Structure
```
Manzil-Bus-System/
├── src/
│   ├── Main.java          # Entry point and UI logic
│   ├── Bus.java           # Bus data model (2D seat array)
│   ├── Passenger.java     # Passenger details model
│   ├── Booking.java       # Ticket transaction model
│   ├── BusService.java    # Core business logic
│   └── DataManager.java   # File I/O and serialization
├── data/                  # Auto-generated .dat files (created on first run)
├── statement.md           # Problem statement and project scope
└── README.md              # Project documentation
```

## Author

**Name: Aditya Abhinab**
*Subject: Programming in Java*

Built as part of the "Build Your Own Project" evaluation.
