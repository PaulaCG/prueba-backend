# Prueba Técnica

Este es un sistema backend desarrollado en Java con Spring Boot para la administración de vehículos, automóviles, camiones y sus mantenciones. Parte 1.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database (en memoria)
- Maven
- Postman (para pruebas)

---

## Estructura del proyecto

```
src/
 └── main/
     ├── java/
     │   └── com.paula.vehiculos/
     │       ├── model/
     │       ├── repository/
     │       ├── service/
     │       ├── controller/
     │       └── exception/
     └── resources/
         └── application.properties
```

---

## Entidades

### `Vehiculo` (abstracto)
- id
- marca
- modelo
- patente
- año
- kilometraje
- cilindrada
- Listado de `mantenciones`

### `Automovil` (hereda de `Vehiculo`)
- tipo
- numeroPuertas
- capacidadPasajeros
- capacidadMaletero

### `Camion` (hereda de `Vehiculo`)
- tipo
- capacidadToneladas
- cantidadEjes

### `Mantencion`
- id
- fecha
- descripcion
- costo
- vehiculo (relación @ManyToOne)

---

## Endpoints REST (CRUD)

### Vehículos generales

| Método | URL              | Acción                          |
|--------|------------------|---------------------------------|
| GET    | `/vehiculos`     | Listar todos los vehículos      |
| GET    | `/vehiculos/{id}`| Obtener un vehículo por ID      |

### Automóviles

| Método | URL                     | Acción                        |
|--------|-------------------------|-------------------------------|
| GET    | `/automoviles`         | Listar automóviles            |
| GET    | `/automoviles/{id}`    | Obtener por ID                |
| POST   | `/automoviles`         | Crear                         |
| PUT    | `/automoviles/{id}`    | Editar                        |
| DELETE | `/automoviles/{id}`    | Eliminar                      |

### Camiones

| Método | URL                  | Acción                         |
|--------|----------------------|--------------------------------|
| GET    | `/camiones`         | Listar camiones                |
| GET    | `/camiones/{id}`    | Obtener por ID                 |
| POST   | `/camiones`         | Crear                          |
| PUT    | `/camiones/{id}`    | Editar                         |
| DELETE | `/camiones/{id}`    | Eliminar                       |

### Mantenciones

| Método | URL                                | Acción                             |
|--------|-------------------------------------|------------------------------------|
| GET    | `/mantenciones/vehiculo/{id}`      | Ver mantenciones por vehículo      |

---

## Manejo de errores

Cuando se solicita un recurso inexistente (GET, PUT o DELETE), el sistema retorna:

```json
{
  "error": "Elemento no encontrado"
}
```

Con código de estado HTTP `404 Not Found`.

---

## Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/PaulaCG/prueba-backend
   cd vehiculos-backend
   ```

2. Abre el proyecto con IntelliJ IDEA

3. Ejecuta la clase:
   ```
   VehiculosBackendApplication.java
   ```

4. Accede a Postman y prueba los endpoints en:
   ```
   http://localhost:8080
   ```

---

## Autor

**Paula Cabrera**  
Prueba técnica para entrevista de desarrollo backend.