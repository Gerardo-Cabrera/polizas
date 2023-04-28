package com.polizas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventario")
public class Inventario {
    @Id
    private Long sku;
    private String nombre;
    private Integer cantidad;

    //Getters 
    public Long getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    //Setters
    public void setSku(Long sku) {
        this.sku = sku;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
