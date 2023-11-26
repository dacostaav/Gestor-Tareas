package com.example.demo;

import java.util.PriorityQueue;

public class ColaTareas {
    private PriorityQueue<Tarea> colaTareas;

    public ColaTareas() {
        colaTareas = new PriorityQueue<>((t1, t2) -> t1.getFechaVencimiento().compareTo(t2.getFechaVencimiento()));
    }

    public void agregarTarea(Tarea tarea) {
        colaTareas.offer(tarea);
    }

    public Tarea obtenerSiguienteTarea() {
        return colaTareas.peek();
    }

    public void eliminarSiguienteTarea() {
        colaTareas.poll();
    }
}
