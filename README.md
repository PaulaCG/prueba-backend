# Prueba Técnica

## Parte 1

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

## Parte 2

## Consultas MySQL: 
### Las consultas SQL requeridas en la Parte 2 de la prueba técnica están en: sql/consultas.sql

---

## Parte 3
### SpringBoot: empleados_reporte_api

Importante: Este proyecto tiene un propósito teórico y de diseño.
No se cuenta con la base de datos real cargada, por lo que las consultas no están implementadas.
Sin embargo, se ha definido la estructura completa de:

Controladores (@RestController)
Servicios (@Service)
Repositorios (@Repository)
DTOs (objetos de respuesta para el API)

Cada endpoint incluye en el código los comentarios que indican:
A qué consulta del enunciado corresponde.
Qué información debería entregar.
Dónde se debería implementar la consulta SQL (en el ReportRepository).

### Endpoints de Reportes de Empleados

### i-- Obtener cantidad de empleados por segmento salarial

**Endpoint: GET /api/empleados/segmentos**

**Respuesta esperada:**
```json
[
  { "segmentoSalarial": "Segmento A", "cantidadEmpleados": 23 },
  { "segmentoSalarial": "Segmento B", "cantidadEmpleados": 48 },
  { "segmentoSalarial": "Segmento C", "cantidadEmpleados": 15 }
]
 
```
La consulta debería implementarse en ReportRepository -> obtenerSegmentos().

### ii-- Obtener cantidad de empleados por segmento salarial, agrupado por departamento

**Endpoint: GET /api/empleados/segmentos/departamentos**

**Respuesta esperada:**
```json
[
  { "departamento": "Finance", "segmentoSalarial": "Segmento A", "cantidadEmpleados": 4 },
  { "departamento": "Finance", "segmentoSalarial": "Segmento B", "cantidadEmpleados": 8 },
  { "departamento": "Finance", "segmentoSalarial": "Segmento C", "cantidadEmpleados": 3 },
  { "departamento": "IT", "segmentoSalarial": "Segmento B", "cantidadEmpleados": 5 },
  { "departamento": "IT", "segmentoSalarial": "Segmento C", "cantidadEmpleados": 2 }
]
```
La consulta debería implementarse en ReportRepository -> obtenerSegmentosPorDepartamento().

### iii-- Obtener la información del empleado con mayor sueldo por cada departamento

**Endpoint: GET /api/empleados/mayor-sueldo**

**Respuesta esperada:**
```json
[
  {
    "employeeId": 101,
    "firstName": "John",
    "lastName": "Doe",
    "departmentName": "Finance",
    "salary": 12000.0
  },
  {
    "employeeId": 205,
    "firstName": "Jane",
    "lastName": "Smith",
    "departmentName": "IT",
    "salary": 9800.0
  }
]
```
La consulta debería implementarse en ReportRepository -> obtenerEmpleadosConMayorSueldoPorDepartamento().

### iv-- Obtener la información de los gerentes contratados hace más de 15 años

**Endpoint: GET /api/empleados/gerentes-antiguos**

**Respuesta esperada:**
```json
[
  {
    "employeeId": 102,
    "firstName": "Jane",
    "lastName": "Smith",
    "jobId": "FIN_MANAGER",
    "salary": 9500.0,
    "hireDate": "2005-03-15"
  },
  {
    "employeeId": 210,
    "firstName": "Robert",
    "lastName": "Green",
    "jobId": "IT_MANAGER",
    "salary": 10500.0,
    "hireDate": "2004-07-21"
  }
]
```
La consulta debería implementarse en ReportRepository -> obtenerGerentesAntiguos().

### v-- Obtener el salario promedio de los departamentos que tienen más de 10 empleados

**Endpoint: GET /api/departamentos/salario-promedio**

**Respuesta esperada:**
```json
[
  { "departmentName": "IT", "salarioPromedio": 9500.0, "cantidadEmpleados": 15 },
  { "departmentName": "Finance", "salarioPromedio": 8700.0, "cantidadEmpleados": 12 }
]
```
La consulta debería implementarse en ReportRepository -> obtenerSalarioPromedioPorDepartamento().

### vi-- Obtener la información agrupada por país

**Endpoint: GET /api/paises/estadisticas-empleados**

**Respuesta esperada:**
```json
[
  {
    "countryName": "USA",
    "cantidadEmpleados": 35,
    "salarioPromedio": 8500.0,
    "salarioMaximo": 15000.0,
    "salarioMinimo": 3000.0,
    "antiguedadPromedio": 12.3
  },
  {
    "countryName": "UK",
    "cantidadEmpleados": 22,
    "salarioPromedio": 9200.0,
    "salarioMaximo": 14500.0,
    "salarioMinimo": 3500.0,
    "antiguedadPromedio": 9.8
  }
]
```
La consulta debería implementarse en ReportRepository -> obtenerEstadisticasPorPais().

---
## Autor

**Paula Cabrera**  
Prueba técnica para entrevista de desarrollo backend.