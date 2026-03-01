# Kotlin OOP Parking Lot (LLD)

A **Low-Level Design (LLD)** implementation of a **Parking Lot system** in **Kotlin**, built using **Object-Oriented Programming** principles and clean, extensible design.

The system simulates a real parking lot experience:
- A driver enters → receives a ticket
- The lot assigns a spot based on **vehicle size**
- The lot records **entry time**
- The driver exits → presents ticket → system calculates **fee**
- The spot becomes available again

---

## Features

- ✅ Vehicle types and sizes (e.g., Motorcycle, Car, Truck)
- ✅ Spot types and sizes (Small / Medium / Large)
- ✅ Spot assignment rules based on vehicle size
- ✅ Ticket issuance + entry time tracking
- ✅ Exit flow: validate ticket, compute fee, free spot
- ✅ Availability tracking per spot type
- ✅ Extensible pricing strategies (hourly / flat / progressive)

---

## Core Requirements Covered

- Assign spots based on vehicle size
- Create and manage tickets
- Record entry and exit timestamps
- Calculate parking fee on exit
- Release spot for new vehicles
- Keep availability updated

---

## Design Overview (OOP)

### Main Entities
- **Vehicle** (abstract)  
  - `Motorcycle`, `Car`, `Truck`
- **ParkingSpot**
  - Spot has `id`, `size`, and `isFree`
- **Ticket**
  - `ticketId`, `vehicle`, `spotId`, `entryTime`, `exitTime?`, `isPaid`
- **ParkingLot**
  - Holds all spots and active tickets
  - Responsible for assigning/freeing spots
- **PricingStrategy**
  - Interface for fee calculation
  - Example: `HourlyPricingStrategy`

### Why this design?
- **Single Responsibility:** each class has one clear job  
- **Open/Closed:** add new vehicle types or pricing without rewriting the whole system  
- **Testable:** logic is separated into small components

