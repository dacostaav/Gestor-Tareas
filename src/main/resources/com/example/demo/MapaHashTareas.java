package com.example.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapaHashTareas {
    private Map<String, Tarea> mapaTareas;

    public MapaHashTareas() {
        mapaTareas = new HashMap<>();
    }

    public void agregarTarea(String clave, Tarea tarea) {
        mapaTareas.put(clave, tarea);
    }

    public Tarea obtenerTarea(String clave) {
        return mapaTareas.get(clave);
    }

    public boolean contieneTarea(String clave) {
        return mapaTareas.containsKey(clave);
    }

    public void eliminarTarea(String clave) {
        mapaTareas.remove(clave);
    }

    public Map<String, Tarea> obtenerMapaTareas() {
        return Collections.unmodifiableMap(mapaTareas);
    }
}
