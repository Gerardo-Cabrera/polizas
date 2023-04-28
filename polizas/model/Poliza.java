package com.polizas.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;


@ToString
@Entity
@Table(name = "polizas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Poliza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // @Column(name = "empleado_genero")
    // private Long empleadoGenero;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleadoGenero;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    @Column(name = "sku")
    private Long sku;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "fecha")
    private LocalDate fecha;

    // Getters
    public Long getId() {
        return id;
    }

    // public Long getEmpleadoGenero() {
    //     return empleadoGenero;
    // }

    public Empleado getEmpleadoGenero() {
        return empleadoGenero;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Long getSku() {
        return sku;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    // public void setEmpleadoGenero(Long empleadoGenero) {
    //     this.empleadoGenero = empleadoGenero;
    // }

    public void setEmpleadoGenero(Empleado empleadoGenero) {
        this.empleadoGenero = empleadoGenero;
    }

    public void setInventario(Inventario inventario) { // Agrega este método
        this.inventario = inventario;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
