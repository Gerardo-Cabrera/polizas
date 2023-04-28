package com.polizas.dto;

import com.polizas.model.Empleado;
import com.polizas.model.Inventario;
import com.polizas.model.Poliza;

public class PolizaRequest {
    private PolizaData data;

    public PolizaData getData() {
        return data;
    }

    public void setData(PolizaData data) {
        this.data = data;
    }

    public static class PolizaData {
        private Poliza poliza;
        private Empleado empleado;
        private Inventario detalleArticulo;

        public Poliza getPoliza() {
            return poliza;
        }

        public void setPoliza(Poliza poliza) {
            this.poliza = poliza;
        }

        public Empleado getEmpleado() {
            return empleado;
        }

        public void setEmpleado(Empleado empleado) {
            this.empleado = empleado;
        }

        public Inventario getDetalleArticulo() {
            return detalleArticulo;
        }

        public void setDetalleArticulo(Inventario detalleArticulo) {
            this.detalleArticulo = detalleArticulo;
        }
    }
}
