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
