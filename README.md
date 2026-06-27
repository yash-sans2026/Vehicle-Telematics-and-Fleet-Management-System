# Fleet Management System

A Spring Boot-based Fleet Management System for managing vehicles, trips, fuel usage, service records, telemetry, users, and driver safety data. The application includes role-based dashboards rendered with Thymeleaf and secured with Spring Security.

## Tech Stack

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA / Hibernate
- Spring Security
- Thymeleaf
- MySQL
- Maven Wrapper

## Features

- Role-based login and dashboard routing
- Fleet vehicle registration and tracking
- Trip dashboard and trip data APIs
- Driver dashboard with recent trips, scores, and profile data
- Fuel log analytics and summary statistics
- Vehicle service and maintenance dashboard
- Safety dashboard with driver score data
- Admin dashboard and user listing
- Startup dummy data loading for users and vehicles

## User Roles

The application supports these roles:

- `ADMIN`
- `FLEET_MANAGER`
- `DRIVER`
- `SERVICE_ENGINEER`
- `SAFETY_OFFICER`
- `OPERATIONS_ANALYST`

## Project Structure

```text
src/
  main/
	java/com/example/fleet_management_system/
	  config/       # Security and startup data loading
	  controller/   # REST and MVC controllers
	  entity/       # JPA entities and enums
	  repository/   # Spring Data repositories
	  service/      # Business logic and simulation services
	  utils/        # Dummy data generators
	resources/
	  templates/    # Thymeleaf pages
	  application.properties
  test/
	java/           # Spring Boot tests
```

## Prerequisites

Before running the application, install:

- JDK 21
- MySQL Server
- Git, if cloning from a repository

You do not need to install Maven separately because the project includes Maven Wrapper scripts.

## Database Configuration

The default database settings are defined in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fleetmanagement?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=create
```

By default, the application connects to MySQL on `localhost:3306` and creates the `fleetmanagement` database if it does not already exist.

> Note: `spring.jpa.hibernate.ddl-auto=create` recreates the schema on startup. This is useful for development, but should be changed before using persistent production data.

## Getting Started on Windows

From the project root:

```powershell
cd C:\Users\2505265\Desktop\Fleet-Management-System
```

Build the project:

```powershell
.\mvnw.cmd clean install
```

Run tests:

```powershell
.\mvnw.cmd test
```

Start the application:

```powershell
.\mvnw.cmd spring-boot:run
```

Then open:

```text
http://localhost:8080/
```

## Demo Login Accounts

On startup, `DataLoader` inserts dummy users when the users table is empty. These accounts are intended for local development only.

| Role | Email | Password |
| --- | --- | --- |
| Admin | `admin@gmail.com` | `admin123` |
| Fleet Manager | `fleet@gmail.com` | `fleet123` |
| Driver | `driver@gmail.com` | `driver123` |
| Safety Officer | `safety@gmail.com` | `safety123` |
| Service Engineer | `service@gmail.com` | `service123` |
| Operations Analyst | `analyst@gmail.com` | `analyst123` |

After login, users are redirected according to their role:

- Admin: `/admin/dashboard`
- Fleet Manager: `/fleet/vehicles/register`
- Driver: `/driver/dashboard`
- Service Engineer: `/service/dashboard`
- Safety Officer: `/safety/dashboard`
- Operations Analyst: `/analyst/dashboard`

## Main Pages

- `/` - Login page
- `/admin/dashboard` - Admin dashboard
- `/fleet/vehicles/register` - Fleet vehicle registration page
- `/driver/dashboard` - Driver dashboard
- `/service/dashboard` - Service dashboard
- `/safety/dashboard` - Safety dashboard
- `/analyst/dashboard` - Fuel analytics dashboard
- `/trip/dashboard` - Trip dashboard

## API Endpoints

The project includes these API route groups:

- `/api/admin/**` - Admin dashboard and users
- `/api/fleet/vehicles/**` - Fleet vehicle APIs
- `/api/driver/**` - Driver dashboard, trips, scores, and profile APIs
- `/api/service/**` - Service dashboard APIs
- `/api/safety/**` - Safety dashboard and driver score APIs
- `/api/fuel-logs/**` - Fuel log and fuel statistics APIs
- `/api/trips/**` - Trip APIs

Access to these endpoints is controlled by Spring Security based on user roles.

## Useful Commands

Clean build output:

```powershell
.\mvnw.cmd clean
```

Compile without running tests:

```powershell
.\mvnw.cmd clean package -DskipTests
```

Run the generated JAR after packaging:

```powershell
java -jar target\fleet-management-system-0.0.1-SNAPSHOT.jar
```

## Development Notes

- The app uses form login with `email` and `password` fields.
- Plain demo passwords are accepted through Spring Security's `{noop}` handling in development.
- CSRF is currently disabled in the security configuration.
- Template files are stored under `src/main/resources/templates`.
- JPA SQL logging is enabled with `spring.jpa.show-sql=true`.

## Testing

Run all tests with:

```powershell
.\mvnw.cmd test
```

The default test class is located at:

```text
src/test/java/com/example/fleet_management_system/FleetManagementSystemApplicationTests.java
```

