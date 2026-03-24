# ✈️ Airplane Ticket Booking API - Backend

Sistema de gestión de vuelos y reservas desarrollado con **Java 17** y **Spring Boot 3.4.3**. El proyecto aplica principios de **Arquitectura Hexagonal** y **Clean Code** para garantizar un sistema escalable, mantenible y testeable.

# PASOS PARA INICIAR EN EL IDE DE INTELLIJ
## 1   CLONA EL REPO
## 2   EN EL IDE ABRE LA CARPETA
## 3   CONFIGURA LAS VALIABLE DE ENTORNO INTERNAMENTE EN EL ID (ESTAN EL .doc)
### 4   EJECUTA 
```
mvn clean install -DskipTests
```
### 5 EJECUTA
```
mvn test
```
### 6 EJECUTA
```
mvn spring-boot:run
```
## POSTMAN
## Post
## http://localhost:8085/airline/flight/save
```


{
  "flightNumber": "AFj-1234dsa7",
  "origin": "Bogotá (BOG)",
  "destination": "Madrid (MAD)",
  "leavedTime": "15/05/2026 08:30:00",
  "arrivedTime": "15/05/2026 22:45:00",
  "totalSeats": 180,
  "price": 850.50
}
```
## 🛠️ Stack Tecnológico

* **Java 17**: Lenguaje principal.
* **Spring Boot 3.4.3**: Framework base (Web, Data JPA, Validation).
* **PostgreSQL**: Motor de base de datos relacional.
* **MapStruct 1.6.3**: Mapeo eficiente entre entidades de dominio, JPA y DTOs.
* **Lombok**: Reducción de código boilerplate (Getters, Setters, Builders).
* **JaCoCo**: Generación de reportes de cobertura de código.
* **Maven**: Gestión de dependencias y ciclo de vida del proyecto.

---

## 🏗️ Arquitectura del Sistema

El proyecto está dividido en capas siguiendo el patrón de **Puertos y Adaptadores**:

1.  **Domain**: Contiene las reglas de negocio, entidades (Flight, Booking, Ticket) y Value Objects.
2.  **Application**: Define los casos de uso y las interfaces (Ports) para interactuar con el dominio.
3.  **Infrastructure**: Implementaciones de persistencia (JPA Repositories), controladores REST y adaptadores externos.

---

## ⚙️ Configuración e Instalación

### Requisitos
* Intellij IDE
* JDK 17 instalado.
* Maven 3.8+ instalado.


