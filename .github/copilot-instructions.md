# Copilot instructions for delivery-api

These notes help AI coding agents work productively in this repository. Keep instructions short and actionable; reference files shown below.

Overview
- This is a small Spring Boot application (Java 21) named `delivery-api`.
- Entry point: `src/main/java/com/delivery_tech/delivery_api/DeliveryApiApplication.java` (annotated with `@SpringBootApplication`).
- Build: Maven (`pom.xml`) using Spring Boot 3.5.6 parent. Key lifecycle: `mvn package`, `mvn test`.
- Runtime: Spring Boot embedded server. No external application server config.

Where to look
- `pom.xml` — dependencies and Java version (Java 21). Use it to determine build and test commands.
- `src/main/java` — service, controller, and entity code (standard Spring Boot layout).
- `src/main/resources/application.properties` — runtime configuration (currently minimal; default app name `delivery-api`).
- `readme.md` and `HELP.md` — repository-level notes (sparse in this project).

Project-specific conventions
- Package naming uses `com.delivery_tech.delivery_api` (underscores present). Preserve this exact package name when creating new classes and tests.
- Lombok is included as an optional dependency. If generating code, prefer using Lombok annotations where existing classes use them; otherwise match the project's existing style.
- H2 database is included at runtime for local/in-memory DB. Expect JPA entities and repositories; when adding migrations or schema changes, prefer code-first JPA entities.

Build & test commands
- Build without tests:

```powershell
mvn -DskipTests package
```

- Run tests:

```powershell
mvn test
```

- Run the application locally (from project root):

```powershell
mvn spring-boot:run
```

Patterns and examples
- Application bootstrap: `DeliveryApiApplication.java` uses Spring Boot auto-configuration; look for `@RestController`, `@Service`, `@Repository` classes under `src/main/java` for endpoints and business logic.
- Persistence: JPA (spring-boot-starter-data-jpa). Check for `@Entity` classes and `JpaRepository` interfaces when changing data model.

Integration & external deps
- No external services are configured in `application.properties`; the project is self-contained with H2 for runtime. If you add external integrations, add configuration keys to `src/main/resources/application.properties` and document them in `readme.md`.

Editing guidance for AI agents
- Make minimal, focused changes: add tests when modifying behavior; update `pom.xml` only to add well-known libraries (explain changes in commit message).
- Preserve package names with underscores. Keep Java target version 21 unless updating `pom.xml` and compile settings.
- When introducing new properties, add defaults to `src/main/resources/application.properties` and explain their purpose in a one-line comment in `readme.md`.

Example quick tasks
- To add a new REST endpoint: add a `@RestController` class under `src/main/java/com/delivery_tech/delivery_api/controller`, wire a service from `service` package, and add a simple integration test under `src/test/java/com/delivery_tech/delivery_api`.
- To add a JPA entity: create an `@Entity` under `domain` or `model` package, a `JpaRepository` in `repository` package, and use H2 for tests (no extra config needed).

Files to reference in PRs
- Always include affected Java files, updated `pom.xml` (if any), `src/main/resources/application.properties` (if you add config), and tests under `src/test/java`.

If anything is unclear or you need repository-specific examples (controllers, entities, tests), ask and I will scan and add them.
