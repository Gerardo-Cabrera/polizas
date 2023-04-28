package com.polizas.controllers;

import com.polizas.dto.PolizaRequest;
import com.polizas.model.Poliza;
import com.polizas.service.PolizaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/polizas")
public class PolizaController {

    @Autowired
    private PolizaService polizaService;

    // Crear póliza
    @PostMapping
    public ResponseEntity<Poliza> createPoliza(@RequestBody PolizaRequest polizaRequest) {
        //log.info("Creando nueva póliza: {}", poliza);

        // Imprimir la información del atributo SKU
        //log.info("SKU recibido: {}", poliza.getSku());
        //log.info("Cantidad recibida: {}", poliza.getCantidad());
        //log.info("Empleado recibido: {}", poliza.getEmpleadoGenero());
        //log.info("Fecha recibida: {}", poliza.getFecha());

        try {
            Poliza createdPoliza = polizaService.createPoliza(polizaRequest);
            return new ResponseEntity<>(createdPoliza, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al crear la póliza: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todas las pólizas
    @GetMapping
    public ResponseEntity<List<Poliza>> getAllPolizas() {
        try {
            List<Poliza> polizas = polizaService.findAll();
            return new ResponseEntity<>(polizas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una póliza por ID
    @GetMapping("/{id}")
    public ResponseEntity<Poliza> getPolizaById(@PathVariable("id") Long id) {
        try {
            //Poliza poliza = polizaService.findById(id).orElseThrow(() -> new IllegalArgumentException("Poliza no encontrada con el ID: " + id));;
            //return new ResponseEntity<>(poliza, HttpStatus.OK);
            Optional<Poliza> polizaOptional = polizaService.findById(id);
            return polizaOptional.map(poliza -> new ResponseEntity<>(poliza, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar póliza
    @PutMapping("/{id}")
    public ResponseEntity<Poliza> updatePoliza(@PathVariable("id") Long id, @RequestBody Poliza poliza) {
        try {
            poliza.setId(id);
            Poliza updatedPoliza = polizaService.updatePoliza(poliza);
            return new ResponseEntity<>(updatedPoliza, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar póliza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoliza(@PathVariable("id") Long id) {
        try {
            polizaService.deletePoliza(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}