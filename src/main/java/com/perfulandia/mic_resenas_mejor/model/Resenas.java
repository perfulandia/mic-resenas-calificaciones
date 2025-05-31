package com.perfulandia.mic_resenas_mejor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name="resenas")

public class Resenas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double calificacion;

    @Column(nullable = false)
    private String id_producto;
    
    @Column(nullable = false)
    private String id_usuario;

    @Column(length = 100, nullable = false)
    private String comentario;
}

/* confirmando pull request */


/*
 Este código Java define una clase de entidad llamada Resenas que representa reseñas y calificaciones en una aplicación Spring Boot 
 con JPA/Hibernate. Aquí está el desglose:
 
Anotaciones Principales

    @Entity: Indica que esta clase es una entidad JPA que se mapeará a una tabla de base de datos.

    @Table(name="resenas"): Especifica que la tabla correspondiente en la base de datos se llamará "resenas".

    @Data (Lombok): Genera automáticamente getters, setters, toString(), equals() y hashCode().

    @AllArgsConstructor y @NoArgsConstructor (Lombok): Generan constructores con todos los argumentos y sin argumentos respectivamente.

Campos de la Clase

    id:

        @Id: Marca este campo como la clave primaria.

        @GeneratedValue(strategy = GenerationType.IDENTITY): Configura la generación automática del ID usando auto-incremento en la base de datos.

    calificacion:

        @Column(nullable = false): Indica que este campo no puede ser nulo en la base de datos.

        Tipo Double para almacenar valores decimales (como 4.5, 3.0, etc.).

    comentario:

        @Column(length = 100, nullable = false): Define que este campo tendrá máximo 100 caracteres y no puede ser nulo.

        Tipo String para almacenar texto de la reseña.
 */