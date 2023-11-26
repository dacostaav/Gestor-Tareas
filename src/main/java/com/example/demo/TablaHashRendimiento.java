package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class TablaHashRendimiento {
    private Map<Tarea, Long> datosRendimiento;

    public TablaHashRendimiento() {
        datosRendimiento = new HashMap<>();
    }

    public void registrarTiempoFinalizacion(Tarea tarea, long tiempoFinalizacion) {
        datosRendimiento.put(tarea, tiempoFinalizacion);
    }

    public long obtenerTiempoFinalizacion(Tarea tarea) {
        return datosRendimiento.getOrDefault(tarea, -1L); // -1L indica que la tarea no ha sido completada
    }

    public Map<Tarea, Long> obtenerDatosRendimiento() {
        return datosRendimiento;
    }
}
