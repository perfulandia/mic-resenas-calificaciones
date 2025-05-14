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
    
    @Column(length = 100, nullable = false)
    private String comentario;
}
