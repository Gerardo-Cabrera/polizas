package com.polizas.service;

import com.polizas.model.Inventario;
import com.polizas.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> findById(Long id) {
        return inventarioRepository.findById(id);
    }

    public Inventario createInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario updateInventario(Inventario inventario) {
        // Agrega las validaciones necesarias antes de actualizar el inventario
        return inventarioRepository.save(inventario);
    }

    public void deleteInventario(Long id) {
        // Agrega las validaciones necesarias antes de eliminar el inventario
        inventarioRepository.deleteById(id);
    }
}
