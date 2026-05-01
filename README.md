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

### ☁️ Infraestructura como Código (IaC)
En la carpeta `infrastructure/terraform` se incluye la configuración para gestionar la base de datos en **Neon**. Se utilizó una estrategia de vinculación mediante `terraform import` para adoptar recursos existentes y asegurar que la infraestructura sea reproducible y auditable.

---

## 📋 Funcionalidades Destacadas
Además de los servicios CRUD básicos, se implementó la lógica de negocio requerida:
*   **Top Stock:** Consulta del producto con mayor stock por sucursal para una franquicia específica.
*   **Actualizaciones Parciales:** Implementación de métodos `PATCH` para la actualización dinámica de nombres en franquicias, sucursales y productos.

---

## 💻 Ejecución Local

### Opción 1: Docker Compose (Recomendado)
Para levantar todo el entorno (App + DB) automáticamente:
```bash
docker-compose up --build
