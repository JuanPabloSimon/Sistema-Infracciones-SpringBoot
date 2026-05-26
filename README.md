# Sistema de Infracciones de Tránsito

Aplicación web desarrollada con **Spring Boot** para la gestión de infracciones de tránsito. Permite registrar conductores, tipos de infracción y actas de infracción, con una interfaz web simple e intuitiva.

## Tecnologías

- Java 21
- Spring Boot 3.4.0
- Spring Data JPA + Hibernate
- MySQL
- Thymeleaf + HTML/CSS/JS (vanilla)
- Lombok

## Funcionalidades

- **Infracciones**: registrar, listar y eliminar infracciones con conductor, tipos, importe y fecha
- **Conductores**: registrar, listar y eliminar conductores
- **Tipos de infracción**: precargados automáticamente (Grave, Media, Leve)
- Filtros por gravedad en la lista de infracciones
- Validaciones en el frontend y en el backend

## Configuración

1. Tener MySQL corriendo en `localhost:3306`
2. Crear un archivo `.env` o configurar la variable `DB_PASSWORD` con la contraseña de MySQL
3. En `src/main/resources/application.properties`, ajustar usuario/contraseña si es necesario

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistinfracciones?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD:}
```

> La base de datos `sistinfracciones` se crea automáticamente al iniciar la aplicación.

## Ejecución

```bash
mvn spring-boot:run
```

Luego abrir el navegador en: [http://localhost:8080](http://localhost:8080)

## Estructura del proyecto

```
src/main/java/com/mycompany/infracciones/
├── config/         # Inicialización de datos
├── controllers/    # REST Controllers + HomeController
├── modelo/         # Entidades JPA
├── repositorio/    # Spring Data Repositories
└── services/       # Lógica de negocio

src/main/resources/
├── static/
│   ├── css/        # Estilos
│   └── js/         # Lógica del frontend
└── templates/      # index.html (Thymeleaf)
```

## Autor

Simon Juan Pablo — Facultad — POO 2025
