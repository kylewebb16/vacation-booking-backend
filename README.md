# Spring Boot Vacation Booking API

Professional Spring Boot backend developed to modernize a legacy vacation booking system and serve as a portfolio-ready demonstration of production\-oriented backend skills.

## Project Context (Scenario)
- A travel agency rebuilt its front\-end with Angular, but the legacy back\-end (from the 1990s) produced undocumented bugs when the front\-end fetched or submitted data. The original developer retired and the codebase accumulated tech debt with no ongoing support. This project implements a minimally viable product (MVP) to port mission\-critical functionality to a modern Spring Boot back end, enabling reliable RESTful integration with the unmodified Angular client.
- Note: The legacy back end is an unmaintained monolithic system originating in the early 1990s. It lacks documentation, automated tests, and stable API contracts, which caused undocumented runtime failures when the Angular front end integrated. This project focuses on diagnosing those failures, reverse‑engineering legacy behavior, and porting mission‑critical functionality to a maintainable Spring Boot service while keeping the supplied Angular client unchanged.

## What this shows
- Replacing legacy systems with a modern, testable service layer
- Designing RESTful APIs and DTOs that match front\-end expectations
- Persistence with Spring Data JPA and MySQL, and safe seeding of sample data
- Input validation and CORS configuration to integrate with a separate front end
- Service/repository/controller layering and clean package organization
- Use of Lombok, Maven, and industry tooling for maintainability and speed

## Key Features
- POST checkout endpoint for placing orders and returning tracking numbers
- Purchase and response DTOs, checkout service interface and implementation
- JPA entities and repositories with CORS support for Angular integration
- Validation aligned to the supplied Angular client inputs
- Programmatic seeding of five sample customers (idempotent)
- Clear commit history to demonstrate iterative development

## Tech Stack
- Java, Spring Boot, Spring Data JPA, Spring Data REST
- MySQL, Lombok, Maven
- Angular (front end supplied in `D288 Front End/`), TypeScript, Node.js / npm

## Quick Start
1. Configure the database in `src/main/resources/application.properties`.
2. Build and run the backend:
    - `mvn clean install`
    - `mvn spring-boot:run`
3. (Optional) Run the supplied Angular client in `D288 Front End/`:
    - `npm install`
    - `npm start` or `ng serve`

## Important Paths & Files
- `src/main/java/.../controllers` — REST controllers (checkout endpoint)
- `src/main/java/.../services` — business logic and DTOs
- `src/main/java/.../dao` — JPA repositories
- `src/main/java/.../entities` — data model and enums
- `src/main/resources/application.properties` — DB and app configuration
- `D288 Front End/` — supplied Angular front end (do not modify)

## Endpoints
- `POST /api/checkout/purchase` — place an order (checkout)


