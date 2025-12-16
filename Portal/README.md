# portal
Proyecto ejemplo: API REST para login (Java, Maven, Spring Boot) usando Arquitectura Hexagonal.

## Cómo ejecutar
1. Tener Java 17 y Maven instalados.
2. Ejecutar:
   ```
   mvn spring-boot:run
   ```
3. Login:
   POST /api/auth/login
   Body JSON:
   {
     "username": "user1",
     "password": "password"
   }
