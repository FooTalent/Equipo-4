# FamilyOne

## Descripción
**FamilyOne** es un sistema de gestión de usuarios diseñado para la Asociación de Familias Acogidas de Chile (AFAC). Este sistema permite la administración eficiente de usuarios, mentores, familias y voluntarios, facilitando así la labor de la organización.

## Desarrollo

Es una aplicación construida con **Spring Boot** que utiliza una base de datos **PostgreSQL** y soporte para autenticación con **JWT**. El proyecto incluye configuraciones para el manejo de correos electrónicos, serialización con **Jackson** y **Swagger** para la documentación de la API.

# Equipo Backend

- **Israel Mege** 
- **Nicolás Huanca** 
- **Maximiliano Echeverria** 

## Dependencias Clave

- **Spring Boot 3.3.3:** Marco para el desarrollo de aplicaciones.
- **PostgreSQL:** Base de datos relacional.
- **JWT:** Autenticación mediante JSON Web Tokens.
- **Spring Security:** Seguridad para la aplicación.
- **Java Faker:** Generación de datos para pruebas.
- **Thymeleaf:** Motor de plantillas para la renderización del lado del servidor.
- **Swagger:** Documentación de API.

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17**
- **Maven** 3.6.0+
- **PostgreSQL** (con una base de datos configurada)

## Configuración del proyecto

### Variables de entorno

El proyecto depende de variables de entorno para la correcta configuración de la base de datos, correo y autenticación JWT. Puedes establecer estas variables en un archivo `.env` o configurarlas directamente en tu entorno.

1. **Base de Datos:**
    - `SERVER_PORT`: Puerto en el que se ejecuta la aplicación.
    - `SPRING_DATASOURCE_URL`: URL de la base de datos.
    - `SPRING_DATASOURCE_USERNAME`: Usuario de la base de datos.
    - `SPRING_DATASOURCE_PASSWORD`: Contraseña de la base de datos.

2. **Correo Electrónico:**
    - `SPRING_MAIL_PORT`: Puerto SMTP para el servicio de correo.
    - `SPRING_MAIL_USERNAME`: Usuario de la cuenta de correo (ej: tu correo de Gmail).
    - `SPRING_MAIL_PASSWORD`: Contraseña de la cuenta de correo.

3. **JWT (Autenticación):**
    - `JWT_SECRET_KEY`: Clave secreta para firmar los tokens JWT.
    - `JWT_EXPIRATION_TIME`: Tiempo de expiración del token JWT.
    - `JWT_RESET_EXPIRATION`: Tiempo de expiración para los tokens de reseteo de contraseña.

### Base de datos

Este proyecto utiliza **PostgreSQL**. Asegúrate de que la base de datos esté configurada y corriendo. Puedes modificar las propiedades en el archivo `application.properties` si es necesario.

### Ejecutar el proyecto


1. Clona el repositorio:

    ```bash
    git clone <URL_DEL_REPOSITORIO>
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd somosafac
    ```

3. Configura las variables de entorno necesarias o ajusta el archivo `application.properties` con los valores adecuados.

4. Ejecuta el proyecto utilizando Maven:

    ```bash
    mvn spring-boot:run
    ```

## Base de Datos

La aplicación está configurada para usar PostgreSQL como base de datos. Asegúrate de que el servidor de PostgreSQL esté corriendo y que los valores de conexión en `application.properties` estén configurados correctamente.

## Documentación de la API

La documentación de la API está disponible a través de Swagger. Una vez que la aplicación esté ejecutándose, puedes acceder a la documentación en la siguiente URL:

```bash
http://localhost:8080/swagger-ui/index.html
```

## Pruebas

El proyecto incluye dependencias para pruebas unitarias con JUnit y validaciones de seguridad con spring-security-test. Para ejecutar las pruebas, puedes usar el siguiente comando:

  ```bash
    mvn test
  ```

## Contribuciones

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.

2. Crea una nueva rama:

    ```bash
    git checkout -b feature/nueva-funcionalidad
    ```

3. Realiza tus cambios.

    ```bash
    git commit -m 'Agrega nueva funcionalidad'
    ```

4. Haz push a la rama:

    ```bash
    git push origin feature/nueva-funcionalidad
    ```

5. Abre un Pull Request.

## Despliegue
Puedes acceder al enlace de la API a través del siguiente link: https://somosafac.onrender.com/swagger-ui/index.html

## Licencia

MIT


