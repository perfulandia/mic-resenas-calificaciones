package com.perfulandia.mic_resenas_mejor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.mic_resenas_mejor.model.Resenas;

public interface ResenasRepository extends JpaRepository<Resenas, Long> {
    List<Resenas> findAll(); // Corregido: "Resenas" con mayúscula
    Optional<Resenas> findById(Long id);
    boolean existsById(Long id);
}


/*
 Este código define una interfaz de repositorio para la entidad Resenas que vimos anteriormente, utilizando Spring Data JPA.
  Aquí está el análisis detallado:
  
Estructura Básica

    extends JpaRepository<Resenas, Long>:

        Hereda de JpaRepository que proporciona operaciones CRUD básicas

        <Resenas, Long> indica que trabaja con la entidad Resenas y que su ID es de tipo Long

Métodos Declarados

    List<Resenas> findAll():

        Devuelve una lista de todas las reseñas existentes

        Nota: Este método ya está incluido en JpaRepository, por lo que declararlo explícitamente es redundante

    Optional<Resenas> findById(Long id):

        Busca una reseña por su ID

        Retorna un Optional que puede contener la reseña o estar vacío si no se encuentra

        También es un método que ya provee JpaRepository

    boolean existsById(Long id):

        Verifica si existe una reseña con el ID especificado

        Retorna true si existe, false si no

        Otro método que ya viene con JpaRepository

Funcionalidad Implícita

Aunque solo vemos estos tres métodos declarados, al extender JpaRepository, la interfaz automáticamente hereda muchos otros métodos útiles como:

    save(): Para guardar nuevas reseñas o actualizar existentes

    deleteById(): Para eliminar reseñas por ID

    count(): Para obtener el número total de reseñas

    Entre otros
 */