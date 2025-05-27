package com.perfulandia.mic_resenas_mejor.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perfulandia.mic_resenas_mejor.model.Resenas;
import com.perfulandia.mic_resenas_mejor.repository.ResenasRepository;

@Service
public class ResenasService {
    @Autowired
    private ResenasRepository resenaRepository; 

    public List<Resenas> findAll() {
        return resenaRepository.findAll();
    }
    
    public Optional<Resenas> findById(Long id) {
        return resenaRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return resenaRepository.existsById(id);
    }

    // Métodos adicionales:
    public Resenas save(Resenas resena) {
        return resenaRepository.save(resena);
    }

    public void deleteById(Long id) {
        resenaRepository.deleteById(id);
    }
}


/*
 Este código implementa una clase de servicio (@Service) que actúa como intermediario entre los controladores y el repositorio de reseñas. 
 Aquí está el análisis detallado:
Anotaciones Clave

    @Service:

        Marca esta clase como un componente de servicio de Spring

        Permite su detección automática durante el escaneo de componentes

        Es una especialización de @Component para la capa de lógica de negocio

    @Autowired:

        Inyecta automáticamente una instancia de ResenasRepository

        Proporciona acceso a todas las operaciones de base de datos

Métodos Implementados
Métodos Básicos de Consulta

    findAll():

        Devuelve todas las reseñas existentes

        Simplemente delega al método correspondiente del repositorio

    findById(Long id):

        Busca una reseña específica por su ID

        Retorna un Optional<Resenas> que puede contener la reseña o estar vacío

    existsById(Long id):

        Verifica si existe una reseña con el ID especificado

        Retorna un booleano (true/false)

Métodos de Modificación

    save(Resenas resena):

        Guarda una nueva reseña o actualiza una existente

        Retorna la reseña guardada (con ID generado si es nuevo)

        Maneja tanto operaciones de creación como actualización

    deleteById(Long id):

        Elimina una reseña por su ID

        No retorna ningún valor (void)

        Lanza excepción si el ID no existe (dependiendo de la configuración)
 */

