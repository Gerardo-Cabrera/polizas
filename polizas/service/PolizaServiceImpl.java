package com.polizas.service;

import com.polizas.dto.PolizaRequest;
import com.polizas.model.Empleado;
import com.polizas.model.Inventario;
import com.polizas.model.Poliza;
import com.polizas.repository.PolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PolizaServiceImpl implements PolizaService {
    @Autowired
    private PolizaRepository polizaRepository;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private InventarioService inventarioService;

    @Override
    public List<Poliza> findAll() {
        return polizaRepository.findAll();
    }

    @Override
    public Optional<Poliza> findById(Long id) {
        return polizaRepository.findById(id);
    }

    @Override
    public Poliza createPoliza(PolizaRequest polizaRequest) {
        Long empleadoId = polizaRequest.getData().getEmpleado().getIdEmpleado();

        if (empleadoService.findById(empleadoId).isEmpty()) {
            throw new IllegalArgumentException("El empleado no existe.");
        }

        // Guarda el empleado
        Empleado empleado = empleadoService.createEmpleado(polizaRequest.getData().getEmpleado());

        Long sku = polizaRequest.getData().getDetalleArticulo().getSku();
        
        if (inventarioService.findById(sku).isEmpty()) {
            throw new IllegalArgumentException("El inventario no existe.");
        }

        // Guarda el detalle del artículo (inventario)
        Inventario inventario = inventarioService.createInventario(polizaRequest.getData().getDetalleArticulo());

        Poliza poliza = polizaRequest.getData().getPoliza();
        poliza.setEmpleadoGenero(empleado);
        poliza.setInventario(inventario);

        return polizaRepository.save(poliza);
    }

    @Override
    public Poliza updatePoliza(Poliza poliza) {
        if (poliza.getId() == null || !polizaRepository.existsById(poliza.getId())) {
            throw new IllegalArgumentException("La póliza a actualizar debe tener un ID válido.");
        }

        Long empleadoId = poliza.getEmpleadoGenero().getIdEmpleado();

        if (empleadoService.findById(empleadoId).isEmpty()) {
            throw new IllegalArgumentException("El empleado no existe.");
        }

        Long sku = poliza.getSku();
        
        if (inventarioService.findById(sku).isEmpty()) {
            throw new IllegalArgumentException("El inventario no existe.");
        }
        
        return polizaRepository.save(poliza);
    }

    @Override
    public void deletePoliza(Long id) {
        if (!polizaRepository.existsById(id)) {
            throw new IllegalArgumentException("La póliza a eliminar debe tener un ID válido.");
        }

        polizaRepository.deleteById(id);
    }
}