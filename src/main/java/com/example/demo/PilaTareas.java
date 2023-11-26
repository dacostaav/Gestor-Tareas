package com.example.demo;

import java.util.Stack;

public class PilaTareas {
    private Stack<Tarea> pilaTareas;

    public PilaTareas() {
        pilaTareas = new Stack<>();
    }

    public void agregarTarea(Tarea tarea) {
        pilaTareas.push(tarea);
    }

    public Tarea obtenerTareaReciente() {
        return pilaTareas.peek();
    }

    public void eliminarTareaReciente() {
        pilaTareas.pop();
    }
}
