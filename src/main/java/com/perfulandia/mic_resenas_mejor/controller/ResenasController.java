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
                // Actualizar campos necesarios
                resenaExistente.setComentario(resenaDetails.getComentario());
                resenaExistente.setCalificacion(resenaDetails.getCalificacion());
                // Agrega más campos si tu entidad los tiene
                
                Resenas resenaActualizada = resenaService.save(resenaExistente);
                return new ResponseEntity<>(resenaActualizada, HttpStatus.OK);
            })
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
