package com.polizas.service;

import com.polizas.model.Empleado;
import com.polizas.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado updateEmpleado(Empleado empleado) {
        // Agrega las validaciones necesarias antes de actualizar el empleado
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Long id) {
        // Agrega las validaciones necesarias antes de eliminar el empleado
        empleadoRepository.deleteById(id);
    }
}
