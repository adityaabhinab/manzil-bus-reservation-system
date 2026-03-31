# Problem Statement: Manzil Bus Reservation System
## 1. Problem Definition
Traditional bus booking systems often lack transparency regarding seat selection. Passengers are commonly assigned seats randomly by the system or booking clerk, leading to discomfort—for example, families being separated or passengers susceptible to motion sickness being assigned back seats. Additionally, small bus operators often struggle with manual record-keeping, which leads to overbooking errors, data loss, and operational inefficiency.

## 2. Proposed Solution
**"Manzil Bus"** is a Java-based console application that digitizes the booking process to solve these issues. Its standout feature is a unique **Visual Seat** Map that displays the bus layout in a grid format. This allows users to see exactly which seats (Window vs. Aisle) are available in real-time and choose their preferred spot, simulating a modern booking experience in a text-based environment.

## 3. Scope
* **Target Users: Travelers:** Who want to book tickets and choose specific seats.
  * **Bus Administrators:** Who need to manage fleet data and view booking history.
* **Core Modules:**
  1. **Bus Fleet Management:** Logic to load, display, and manage bus routes and prices.
  2. **Visual Booking Engine:** The core interactive module that renders the 2D seat grid and processes user selection.
  3. **Data Persistence Layer:** A system to save and retrieve booking records and bus states using file handling.
## 4. Key Features
* **Visual Grid-based Seat Selection:** An innovative console UI that uses 2D arrays to visualize the bus layout (e.g., `[ ]` for empty, `[X]` for booked).
* **Real-time Validation:** Logic to prevent double-booking of the same seat index.
* **Automated Ticket Generation:** Creation of unique Ticket IDs (e.g., `TKT-171...`) for every successful transaction.
* **Data Persistence:** Usage of Java Serialization to store objects in `.dat` files, ensuring data survives application restarts.