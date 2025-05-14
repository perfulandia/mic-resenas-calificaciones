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
