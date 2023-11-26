package com.example.demo;

import java.util.PriorityQueue;

public class FilaPrioridadTareasDinamicas {
    private PriorityQueue<TareaConPrioridadDinamica> filaPrioridad;

    public FilaPrioridadTareasDinamicas() {
        filaPrioridad = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getPrioridad(), t1.getPrioridad()));
    }

    public void agregarTareaConPrioridadDinamica(TareaConPrioridadDinamica tarea) {
        filaPrioridad.offer(tarea);
    }

    public TareaConPrioridadDinamica obtenerTareaPrioritaria() {
        return filaPrioridad.peek();
    }

    public void actualizarPrioridad(TareaConPrioridadDinamica tarea, int nuevaPrioridad) {
        filaPrioridad.remove(tarea);
        tarea.setPrioridad(nuevaPrioridad);
        filaPrioridad.offer(tarea);
    }

    public String obtenerRepresentacionListaPrioridad() {
        StringBuilder representacion = new StringBuilder();
        for (TareaConPrioridadDinamica tarea : filaPrioridad) {
            representacion.append("Prioridad: ").append(tarea.getPrioridad())
                    .append(", Descripción: ").append(tarea.getDescripcion())
                    .append("\n");
        }
        return representacion.toString();
    }
}

class TareaConPrioridadDinamica extends TareaConPrioridad {
    public TareaConPrioridadDinamica(String descripcion, int prioridad) {
        super(descripcion, prioridad);
    }

    // Método setter para la prioridad dinámica
    @Override
    public void setPrioridad(int nuevaPrioridad) {
        super.setPrioridad(nuevaPrioridad);
    }

    // Puedes añadir más atributos y métodos específicos para tareas dinámicas si es necesario
}

