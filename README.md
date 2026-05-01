# 🚀 Franchise Management: Reactive API

Este proyecto es una solución integral para la gestión de franquicias, sucursales y productos, desarrollada como parte de un reto técnico para **Accenture**. La arquitectura está diseñada bajo el paradigma de **programación reactiva**, asegurando un alto rendimiento y escalabilidad.

## 🌐 Enlaces del Proyecto
*   **API en Producción (Cloud):** [https://franchise-management-rty6.onrender.com/](https://franchise-management-rty6.onrender.com/)
*   **Documentación Interactiva (Swagger):** [https://franchise-management-rty6.onrender.com/swagger-ui.html](https://franchise-management-rty6.onrender.com/swagger-ui.html)
*   **Base de Datos:** PostgreSQL en la nube (Neon Database).

---

## 🛠️ Stack Tecnológico

*   **Backend:** Java 21 + Spring Boot 4.0.6 (Spring WebFlux).
*   **Persistencia:** Driver **R2DBC** para operaciones de base de datos no bloqueantes.
*   **Contenedores:** Docker (Estrategia de Multi-stage build).
*   **Documentación:** OpenAPI 3 / Swagger UI.

---

## 🏗️ Arquitectura y Mejores Prácticas

### ⚡ Programación Reactiva
Se implementó **Spring WebFlux** junto con **R2DBC** para manejar flujos de datos asíncronos. Esto garantiza que la API pueda procesar una gran cantidad de peticiones concurrentes con un uso mínimo de memoria y CPU, ideal para entornos de nube como Render.

### 🐳 Dockerización Profesional
El proyecto incluye un `Dockerfile` optimizado:
1.  **Etapa de Compilación:** Usa Maven y JDK 21 para construir el artefacto.
2.  **Etapa de Ejecución:** Utiliza una imagen **JRE Alpine** (ultra ligera), lo que reduce el tamaño de la imagen final y minimiza la superficie de ataque para mayor seguridad.

### Capa de Dominio
Aquí es donde viven las Entidades. Son clases puras de Java (POJOs) que no saben nada de bases de datos o de la web.

Contenido: Clases Franchise, Branch, Product.

Regla de negocio: Por ejemplo, la validación de que el stock no sea negativo o que el nombre de una franquicia no sea nulo.

Independencia: Si mañana se requiere dejar de usar Spring Boot, estas clases no cambian en absoluto.

### Capa de Infraestructura
Aquí es donde la aplicación "toca" el mundo real. Es la capa más externa y la que más cambia.

Adapters de Entrada (Inbound): Tus Controladores REST. Reciben el JSON del usuario y lo convierten en algo que el Caso de Uso entienda.

Adapters de Salida (Outbound): La implementación de R2DBC. Aquí es donde vive el código que habla con Neon.

Configuración: Aquí es donde vive tu Dockerfile y las variables de entorno de Render.

---

## 📋 Funcionalidades Destacadas
Además de los servicios CRUD básicos, se implementó la lógica de negocio requerida:
*   **Top Stock:** Consulta del producto con mayor stock por sucursal para una franquicia específica.
*   **Actualizaciones Parciales:** Implementación de métodos `PATCH` para la actualización dinámica de nombres en franquicias, sucursales y productos.

---

## 💻 Ejecución Local

Para levantar todo el entorno (App + DB) automáticamente:
```bash
docker run -p 8080:8080 -e SPRING_R2DBC_URL="r2dbc:postgresql://ep-holy-fog-amac2a7c.c-5.us-east-1.aws.neon.tech/neondb?sslmode=require" -e SPRING_R2DBC_USERNAME="neondb_owner" -e SPRING_R2DBC_PASSWORD="npg_4y3gwUsPkVnp" franchise-api
```
