Franchise Management API
Este proyecto es una solución robusta y escalable para la gestión de franquicias, sucursales y productos, desarrollada bajo el paradigma de programación reactiva y principios de Clean Architecture.

🚀 Enlaces del Proyecto
Producción (Cloud): https://franchise-management-rty6.onrender.com/

Documentación Swagger (Prod): https://franchise-management-rty6.onrender.com/swagger-ui.html

Entorno Local: http://localhost:8080/swagger-ui.html

🛠️ Stack Tecnológico
Backend: Java 21, Spring Boot 4.0.6 (Spring WebFlux).

Persistencia: R2DBC con PostgreSQL (Neon Database).

Contenedores: Docker & Docker Compose.

Infraestructura: Terraform (IaC).

Documentación: SpringDoc OpenAPI (Swagger).

🏗️ Arquitectura e Infraestructura
1. Infraestructura como Código (IaC)
Se ha incluido una carpeta infrastructure/terraform con la definición técnica para el aprovisionamiento de la base de datos en Neon. Se utiliza el proveedor de PostgreSQL para asegurar la portabilidad y el control de versiones de los esquemas de datos.

2. Dockerización (Multi-stage Build)
La aplicación cuenta con un Dockerfile optimizado en dos etapas:

Build: Compilación con Maven y JDK 21.

Runtime: Imagen ligera basada en JRE Alpine para reducir el consumo de recursos en el despliegue.

3. Persistencia Reactiva
A diferencia del JDBC tradicional, este proyecto utiliza R2DBC. Esto permite que la aplicación maneje un alto volumen de peticiones concurrentes sin bloquear hilos de ejecución, optimizando el rendimiento del servicio en Render.

📋 Endpoints Principales
La API permite gestionar el ciclo completo de una franquicia:

Franquicias: Crear y renombrar franquicias.

Sucursales: Agregar sucursales a una franquicia y actualizar sus nombres.

Productos: Gestionar stock, eliminar productos y actualizar información.

Consultas de Negocio: Endpoint especializado para obtener el producto con mayor stock por cada sucursal de una franquicia específica.

💻 Guía de Uso Local
Requisitos previos
Docker Desktop iniciado.

Java 21 (si desea ejecutar sin Docker).

Ejecución con Docker Compose
Para levantar todo el entorno (App + Base de Datos local) de forma automática:

Bash
docker-compose up --build
Ejecución de Imagen Individual
Si prefieres conectar el contenedor a la base de datos de la nube (Neon):

Bash
docker run -p 8080:8080 \
  -e SPRING_R2DBC_URL="r2dbc:postgresql://ep-holy-fog-amac2a7c.c-5.us-east-1.aws.neon.tech/neondb?sslmode=require" \
  -e SPRING_R2DBC_USERNAME="neondb_owner" \
  -e SPRING_R2DBC_PASSWORD="tu_password" \
  franchise-api
📄 Notas de Entrega
Base de Datos: Se utiliza una instancia serverless en Neon para asegurar persistencia real en el despliegue de Render.

Validaciones: Se han implementado validaciones en los controladores para asegurar la integridad de los nombres y cantidades de stock.

Documentación: El contrato de la API puede ser exportado en formato JSON desde /v3/api-docs.

Desarrollado por Davi