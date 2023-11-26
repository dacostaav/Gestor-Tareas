package com.example.demo;

import java.util.LinkedList;

public class ListaEnlazadaPrioridad {
    private LinkedList<TareaConPrioridad> listaTareas;

    public ListaEnlazadaPrioridad() {
        listaTareas = new LinkedList<>();
    }

    public void agregarTareaConPrioridad(TareaConPrioridad tarea) {
        int i = 0;
        while (i < listaTareas.size() && tarea.getPrioridad() <= listaTareas.get(i).getPrioridad()) {
            i++;
        }
        listaTareas.add(i, tarea);
    }

    public void mostrarListaPrioridad() {
        for (TareaConPrioridad tarea : listaTareas) {
            System.out.println("Tarea: " + tarea.getDescripcion() + ", Prioridad: " + tarea.getPrioridad());
        }
    }
}

class TareaConPrioridad {
    private String descripcion;
    private int prioridad;

    public TareaConPrioridad(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int nuevaPrioridad) {
        this.prioridad = nuevaPrioridad;
    }
}