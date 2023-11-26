package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArbolDecision {
    private NodoArbolDecision raiz;

    public ArbolDecision() {
        raiz = new NodoArbolDecision("Todas las tareas");
    }

    public void agregarTarea(String categoria, Tarea tarea) {
        raiz.agregarTarea(categoria, tarea);
    }

    public void mostrarCategorias() {
        raiz.mostrarCategorias();
    }
    public String obtenerRepresentacionArbol() {
        return raiz.obtenerRepresentacionArbol(0);
    }

}

class NodoArbolDecision {
    private String categoria;
    private Map<String, NodoArbolDecision> subcategorias;
    private Stack<Tarea> tareas;

    public NodoArbolDecision(String categoria) {
        this.categoria = categoria;
        this.subcategorias = new HashMap<>();
        this.tareas = new Stack<>();
    }

    public void agregarTarea(String categoria, Tarea tarea) {
        if (!subcategorias.containsKey(categoria)) {
            subcategorias.put(categoria, new NodoArbolDecision(categoria));
        }
        subcategorias.get(categoria).tareas.push(tarea);
    }

    public void mostrarCategorias() {
        System.out.println("Categoría: " + categoria);
        for (NodoArbolDecision subcategoria : subcategorias.values()) {
            subcategoria.mostrarCategorias();
        }
        System.out.println("Tareas en " + categoria + ": " + tareas);
    }

    public String obtenerRepresentacionArbol(int nivel) {
        StringBuilder representacion = new StringBuilder();
        String indentacion = "  ".repeat(nivel);
        representacion.append(indentacion).append("Categoría: ").append(categoria).append("\n");

        for (NodoArbolDecision subcategoria : subcategorias.values()) {
            representacion.append(subcategoria.obtenerRepresentacionArbol(nivel + 1));
        }

        representacion.append(indentacion).append("Tareas en ").append(categoria).append(": ").append(tareas).append("\n");

        return representacion.toString();
    }
}
