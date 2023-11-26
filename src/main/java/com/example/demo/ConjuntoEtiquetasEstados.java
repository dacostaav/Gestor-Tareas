package com.example.demo;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoEtiquetasEstados {
    private Set<String> conjuntoEtiquetas;
    private Set<String> conjuntoEstados;

    public ConjuntoEtiquetasEstados() {
        conjuntoEtiquetas = new HashSet<>();
        conjuntoEstados = new HashSet<>();
    }

    public void agregarEtiqueta(String etiqueta) {
        conjuntoEtiquetas.add(etiqueta);
    }

    public void agregarEstado(String estado) {
        conjuntoEstados.add(estado);
    }

    public Set<String> obtenerEtiquetas() {
        return conjuntoEtiquetas;
    }

    public Set<String> obtenerEstados() {
        return conjuntoEstados;
    }
}
