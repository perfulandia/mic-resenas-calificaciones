package com.perfulandia.mic_resenas_mejor.controller;   
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.perfulandia.mic_resenas_mejor.model.Resenas;
import com.perfulandia.mic_resenas_mejor.service.ResenasService;

/*revisado */

/* listo */
@RestController
@RequestMapping("/api/v1/resenas")
public class ResenasController {
    @Autowired
    private ResenasService resenaService;

    @GetMapping
    public ResponseEntity<List<Resenas>> getAllResenas() {
        List<Resenas> resenas = resenaService.findAll(); // Corregido: instancia, no estático
        return resenas.isEmpty() 
            ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
            : new ResponseEntity<>(resenas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resenas> getResenaById(@PathVariable Long id) {
        if (resenaService.existsById(id)) {
            return new ResponseEntity<>(resenaService.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Métodos adicionales:
    @PostMapping
    public ResponseEntity<Resenas> createResena(@RequestBody Resenas resena) {
        return new ResponseEntity<>(resenaService.save(resena), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResena(@PathVariable Long id) {
        resenaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
public ResponseEntity<Resenas> updateResena(
    @PathVariable Long id,
    @RequestBody Resenas resenaDetails
) {
    return resenaService.findById(id)
        .map(resenaExistente -> {
            // Actualizar solo campos modificables
            if(resenaDetails.getComentario() != null) {
                resenaExistente.setComentario(resenaDetails.getComentario());
            }
            if(resenaDetails.getCalificacion() != null) {
                resenaExistente.setCalificacion(resenaDetails.getCalificacion());
            }
            // NO actualizar id_producto ni id_usuario por seguridad
            
            Resenas resenaActualizada = resenaService.save(resenaExistente);
            return new ResponseEntity<>(resenaActualizada, HttpStatus.OK);
        })
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
}




/*
 # Documentación del Controlador ResenasController

## Descripción General
Este controlador REST (`@RestController`) maneja las operaciones CRUD para reseñas a través de los endpoints bajo la ruta base `/api/v1/resenas`. Se comunica con `ResenasService` para realizar las operaciones de negocio y responde con los códigos HTTP apropiados.

## Métodos Implementados

### 1. Obtener todas las reseñas - `GET /api/v1/resenas`
```java
public ResponseEntity<List<Resenas>> getAllResenas()
```
**Función**:  
Retorna todas las reseñas almacenadas en el sistema.

**Respuestas**:
- `200 OK` con la lista de reseñas (si existen registros)
- `204 NO_CONTENT` (si no hay reseñas disponibles)

---

### 2. Obtener reseña por ID - `GET /api/v1/resenas/{id}`
```java
public ResponseEntity<Resenas> getResenaById(@PathVariable Long id)
```
**Función**:  
Busca una reseña específica utilizando su identificador único.

**Respuestas**:
- `200 OK` con la reseña encontrada (si existe)
- `404 NOT_FOUND` (si no existe reseña con ese ID)

---

### 3. Crear nueva reseña - `POST /api/v1/resenas`
```java
public ResponseEntity<Resenas> createResena(@RequestBody Resenas resena)
```
**Función**:  
Crea una nueva reseña con los datos proporcionados en el cuerpo de la solicitud.

**Parámetro**:
- `@RequestBody Resenas resena`: Objeto con los datos de la reseña a crear

**Respuesta**:
- `201 CREATED` con la reseña recién creada

---

### 4. Eliminar reseña - `DELETE /api/v1/resenas/{id}`
```java
public ResponseEntity<Void> deleteResena(@PathVariable Long id)
```
**Función**:  
Elimina permanentemente una reseña del sistema.

**Respuesta**:
- `204 NO_CONTENT` (operación exitosa sin retorno de datos)

---

### 5. Actualizar reseña - `PUT /api/v1/resenas/{id}`
```java
public ResponseEntity<Resenas> updateResena(
    @PathVariable Long id,
    @RequestBody Resenas resenaDetails)
```
**Función**:  
Actualiza los datos de una reseña existente.

**Lógica**:
1. Busca la reseña por ID
2. Si existe, actualiza sus campos (comentario y calificación)
3. Guarda los cambios

**Respuestas**:
- `200 OK` con la reseña actualizada (si existe)
- `404 NOT_FOUND` (si el ID no existe)

## Flujo de Operación
1. El cliente realiza una petición HTTP a uno de los endpoints
2. El controlador recibe la petición y valida los parámetros
3. Delega la operación al `ResenasService` (inyectado mediante `@Autowired`)
4. Procesa la respuesta del servicio
5. Retorna una respuesta HTTP adecuada con:
   - Código de estado correspondiente
   - Datos solicitados (cuando aplica)
   - Encabezados apropiados

## Estructura de Respuestas
Todos los métodos utilizan `ResponseEntity` que permite:
- Encapsular los datos de respuesta
- Controlar el código de estado HTTP
- Agregar cabeceras personalizadas si es necesario

## Notas Técnicas
- Usa anotaciones estándar de Spring:
  - `@PathVariable` para parámetros en la URL
  - `@RequestBody` para datos en el cuerpo de peticiones POST/PUT
  - Verbos HTTP específicos (`@GetMapping`, `@PostMapping`, etc.)
- Sigue convenciones RESTful para diseño de APIs
- La versión en la ruta (`v1`) permite futuras actualizaciones sin romper compatibilidad
 */
