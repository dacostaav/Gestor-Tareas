package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrafoTareas {
    private Map<Tarea, Set<Tarea>> grafo;

    public GrafoTareas() {
        grafo = new HashMap<>();
    }

    public void agregarTarea(Tarea tarea) {
        grafo.put(tarea, new HashSet<>());
    }

    public void agregarRelacionDependencia(Tarea tareaPadre, Tarea tareaHija) {
        if (grafo.containsKey(tareaPadre) && grafo.containsKey(tareaHija)) {
            grafo.get(tareaPadre).add(tareaHija);
        } else {
            System.out.println("Error: Una de las tareas no existe en el grafo.");
        }
    }

    public Set<Tarea> obtenerTareasDependientes(Tarea tarea) {
        return grafo.getOrDefault(tarea, new HashSet<>());
    }

    public Set<Tarea> obtenerTareas() {
        return grafo.keySet();
    }
}