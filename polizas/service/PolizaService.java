package com.polizas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polizas.dto.PolizaRequest;
import com.polizas.model.Poliza;
import com.polizas.repository.EmpleadoRepository;
import com.polizas.repository.InventarioRepository;
import com.polizas.repository.PolizaRepository;


@Service
public interface PolizaService {

    //@Autowired
    //private PolizaRepository polizaRepository;

    // public List<Poliza> findAll() {
    //     return polizaRepository.findAll();
    // }

    // public Optional<Poliza> findById(Long id) {
    //     return polizaRepository.findById(id);
    // }

    // public Poliza createPoliza(Poliza poliza) {
    //     return polizaRepository.save(poliza);
    // }

    // public Poliza updatePoliza(Poliza poliza) {
    //     if (poliza.getId() == null || !polizaRepository.existsById(poliza.getId())) {
    //         throw new IllegalArgumentException("La póliza a actualizar debe tener un ID válido.");
    //     }
    //     return polizaRepository.save(poliza);
    // }

    // public void deletePoliza(Long id) {
    //     if (!polizaRepository.existsById(id)) {
    //         throw new IllegalArgumentException("La póliza a eliminar debe tener un ID válido.");
    //     }
    //     polizaRepository.deleteById(id);
    // }

    //@Autowired
    //private EmpleadoRepository empleadoRepository;
    

    //@Autowired
    //private InventarioRepository inventarioRepository;

    // Implementar lógica de negocio aquí

    
    List<Poliza> findAll();
    
    Optional<Poliza> findById(Long id);

    //Poliza createPoliza(Poliza poliza);
    Poliza createPoliza(PolizaRequest polizaRequest);

    Poliza updatePoliza(Poliza poliza);

    void deletePoliza(Long id);
}
