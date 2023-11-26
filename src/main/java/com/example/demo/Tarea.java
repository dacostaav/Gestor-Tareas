package com.example.demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tarea {
    private String descripcion;
    private String fechaVencimiento;
    private Set<String> etiquetas;
    private String estado;
    private int prioridad;
    // Otros atributos según sea necesario

    public Tarea(String descripcion, String fechaVencimiento, String estado, String prioridad, String etiquetas) {
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.etiquetas = new HashSet<>();
        this.estado = "Pendiente"; // Estado predeterminado
        this.prioridad = 0; // Prioridad predeterminada
    }

    // Métodos para etiquetas
    public void agregarEtiqueta(String etiqueta) {
        etiquetas.add(etiqueta);
    }

    public Set<String> obtenerEtiquetas() {
        return Collections.unmodifiableSet(etiquetas);
    }

    // Métodos para estados
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String obtenerEstado() {
        return estado;
    }

    // Métodos para prioridad
    public void setPrioridad(int nuevaPrioridad) {
        this.prioridad = nuevaPrioridad;
    }

    public int obtenerPrioridad() {
        return prioridad;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

}
