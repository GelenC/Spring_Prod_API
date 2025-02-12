# Gestión de Productos 

📅 **Fecha de creación:** Febrero 2025.  
👨‍💻 **Desarrollador:** Gelen Cueto   
🛠️ **Tecnologías:** Java (Spring Boot), Kotlin (Jetpack Compose), Retrofit, MySQL.

## Descripción del Proyecto
Este sistema permite gestionar productos mediante una API REST. Desde una aplicación móvil en Android, los usuarios pueden listar, buscar, crear, actualizar y eliminar productos. La API se desarrolla en Spring Boot con una base de datos en MySQL.

🔹 Características principales:   
✅ API REST con CRUD de productos.    
✅ Validación de datos en la API.   
✅ Interfaz en Jetpack Compose con Retrofit.   
✅ Persistencia en base de datos SQL.

##  Funcionalidades Implementadas:
✅ **Modelo: Producto →** Representa un producto con id, nombre, precio y fechaCreacion.    
✅ **Repositorio: ProductoRepository →** Extiende JpaRepository para interactuar con la BD.    
✅ **Controlador ProductoController →** Expone los endpoints REST:

````
GET	/productos	→ Obtiene todos los productos
````
````
GET	/productos/{id}	→ Obtiene un producto por su ID
````
````
POST /productos	→ Crea un nuevo producto
````
````
PUT	/productos/{id}	 → Actualiza un producto (sin modificar fecha de creación)
````
````
DELETE /productos/{id}	→ Elimina un producto por ID
````
✅ Configuración de CORS → Para permitir que la app en Android Studio acceda a la API.   
✅ Uso de 10.0.2.2 en Android para acceder a localhost del servidor

## Pasos para Ejecutar

### Backend - Spring Boot

🔹Abrir la terminal en la carpeta del proyecto.

🔹Ejecutar el build con Maven:

````
mvn clean package
````
🔹Iniciar el servidor:

````
mvn spring-boot:run
````

🔹Verificar en el navegador:
````
http://localhost:8080/productos
````

### Frontend - Android Studio

🔹Abrir Android Studio y cargar el proyecto.

🔹Conectar un emulador o dispositivo físico.

🔹Presionar Run > Run 'app'.

## Posibles Mejoras
🔹 Agregar navegación entre pantallas con NavController.   
🔹 Manejo de errores más robusto en las respuestas de Retrofit.   
🔹 Mejorar el diseño con Material 3 y agregar animaciones.
