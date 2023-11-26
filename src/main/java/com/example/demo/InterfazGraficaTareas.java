package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InterfazGraficaTareas extends Application {

    private ColaTareas colaTareas = new ColaTareas();
    private PilaTareas pilaTareas = new PilaTareas();
    private ArbolDecision arbolDecision = new ArbolDecision();
    private MapaHashTareas mapaHashTareas = new MapaHashTareas();
    private ListaEnlazadaPrioridad listaEnlazadaPrioridad = new ListaEnlazadaPrioridad();
    private GrafoTareas grafoTareas = new GrafoTareas();
    private ConjuntoEtiquetasEstados conjuntoEtiquetasEstados = new ConjuntoEtiquetasEstados();
    private FilaPrioridadTareasDinamicas filaPrioridadTareasDinamicas = new FilaPrioridadTareasDinamicas();
    private TablaHashRendimiento tablaHashRendimiento = new TablaHashRendimiento();
    private Set<String> etiquetas = new HashSet<>(); // Usaremos un conjunto para almacenar etiquetas globalmente
    private Map<String, Tarea> tareasPorTitulo = new HashMap<>(); // Mapa para búsqueda rápida por título

    private TextArea tareaTextArea;
    private TextArea resultadoTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Tareas");

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        tareaTextArea = new TextArea();
        tareaTextArea.setPromptText("Ingrese la tarea (formato: Descripcion, FechaVencimiento)");

        Button agregarButton = new Button("Agregar Tarea");
        agregarButton.setOnAction(e -> agregarTarea());

        HBox herramientasBox = new HBox();
        herramientasBox.setSpacing(10);
        herramientasBox.getChildren().addAll(tareaTextArea, agregarButton);

        resultadoTextArea = new TextArea();
        resultadoTextArea.setEditable(false);

        // Botones para mostrar estructuras de datos
        VBox estructurasBox = new VBox();
        estructurasBox.setSpacing(10);

        estructurasBox.getChildren().addAll(
                crearBotonMostrar("Cola de Tareas", this::mostrarCola),
                crearBotonMostrar("Pila de Tareas", this::mostrarPila),
                crearBotonMostrar("Árbol de Decision", this::mostrarArbol),
                crearBotonMostrar("Mapa Hash de Tareas", this::mostrarMapaHash),
                crearBotonMostrar("Lista de Prioridad", this::mostrarListaPrioridad),
                crearBotonMostrar("Grafo de Tareas", this::mostrarGrafo),
                crearBotonMostrar("Conjuntos", this::mostrarConjuntos),
                crearBotonMostrar("Fila de Prioridad Dinámica", this::mostrarFilaPrioridad),
                crearBotonMostrar("Tabla Hash de Rendimiento", this::mostrarTablaHash)
        );

        HBox mostrarBox = new HBox();
        mostrarBox.setSpacing(10);
        mostrarBox.getChildren().add(estructurasBox);

        root.getChildren().addAll(herramientasBox, resultadoTextArea, mostrarBox);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button crearBotonMostrar(String texto, Runnable accion) {
        Button button = new Button(texto);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setOnAction(e -> {
            resultadoTextArea.clear();
            accion.run();
        });
        return button;
    }

    private void agregarTarea() {
        String input = tareaTextArea.getText();
        String[] partes = input.split(",");
        if (partes.length == 5) {
            Tarea tarea = new Tarea(
                    partes[0].trim(),
                    partes[1].trim(),
                    partes[2].trim(),
                    partes[3].trim(),
                    partes[4].trim()
            );

            // Usar las nuevas características de la clase Tarea
            tarea.agregarEtiqueta("EjemploEtiqueta");
            tarea.cambiarEstado("EjemploEstado");
            tarea.setPrioridad(5);

            colaTareas.agregarTarea(tarea);
            pilaTareas.agregarTarea(tarea);
            arbolDecision.agregarTarea("General", tarea);
            mapaHashTareas.agregarTarea(partes[0].trim(), tarea);
            listaEnlazadaPrioridad.agregarTareaConPrioridad(new TareaConPrioridad(partes[0].trim(), 5)); // Prioridad arbitraria
            grafoTareas.agregarTarea(tarea);
            filaPrioridadTareasDinamicas.agregarTareaConPrioridadDinamica(new TareaConPrioridadDinamica(partes[0].trim(), 5));
            tablaHashRendimiento.registrarTiempoFinalizacion(tarea, System.currentTimeMillis());


            tareaTextArea.clear();
            mostrarResultado("Tarea agregada exitosamente.");
        } else {
            mostrarMensaje("Formato de entrada incorrecto. Use: Descripcion, FechaVencimiento, Estado, Prioridad, Etiquetas");
        }
    }




    private void mostrarCola() {
        Tarea tarea = colaTareas.obtenerSiguienteTarea();
        mostrarResultado("Cola de Tareas: " + (tarea != null ? tarea.getFechaVencimiento() : "Vacía"));
    }

    private void mostrarPila() {
        Tarea tarea = pilaTareas.obtenerTareaReciente();
        mostrarResultado("Pila de Tareas: " + (tarea != null ? tarea.getFechaVencimiento() : "Vacía"));
    }

    private void mostrarArbol() {
        String representacionArbol = arbolDecision.obtenerRepresentacionArbol();
        mostrarResultado("Árbol de decision:\n" + representacionArbol);
    }

    private void mostrarMapaHash() {
        String input = tareaTextArea.getText();
        Tarea tarea = mapaHashTareas.obtenerTarea(input.trim());
        mostrarResultado("Tarea encontrada en el Mapa Hash: " + (tarea != null ? tarea.getFechaVencimiento() : "No encontrada"));
    }

    private void mostrarListaPrioridad() {
        String representacionListaPrioridad = filaPrioridadTareasDinamicas.obtenerRepresentacionListaPrioridad();
        mostrarResultado("Lista de Prioridad:\n" + representacionListaPrioridad);
    }

    private void mostrarGrafo() {
        // Mostrar el grafo puede ser más complejo dependiendo de la estructura específica del grafo y la representación visual.
        // Aquí solo se imprime información básica sobre las relaciones entre tareas.
        for (Tarea tarea : grafoTareas.obtenerTareas()) {
            Set<Tarea> tareasDependientes = grafoTareas.obtenerTareasDependientes(tarea);
            mostrarResultado("Tarea: " + tarea.getDescripcion() + ", Dependencias: " + tareasDependientes);
        }
    }

    private void mostrarConjuntos() {
        mostrarResultado("Conjunto de Etiquetas: " + conjuntoEtiquetasEstados.obtenerEtiquetas());
        mostrarResultado("Conjunto de Estados: " + conjuntoEtiquetasEstados.obtenerEstados());
    }

    private void mostrarFilaPrioridad() {
        TareaConPrioridadDinamica tarea = filaPrioridadTareasDinamicas.obtenerTareaPrioritaria();
        mostrarResultado("Fila de Prioridad Dinámica: " + (tarea != null ? tarea.getDescripcion() : "Vacía"));
    }

    private void mostrarTablaHash() {
        StringBuilder representacionTablaHash = new StringBuilder("Tabla Hash de Rendimiento:\n");

        for (Map.Entry<Tarea, Long> entrada : tablaHashRendimiento.obtenerDatosRendimiento().entrySet()) {
            Tarea tarea = entrada.getKey();
            Long tiempoFinalizacion = entrada.getValue();

            representacionTablaHash.append("Tarea: ").append(tarea.getDescripcion())
                    .append(", Tiempo de Finalización: ").append(tiempoFinalizacion).append("\n");
        }

        mostrarResultado(representacionTablaHash.toString());
    }

    private void mostrarResultado(String mensaje) {
        resultadoTextArea.appendText(mensaje + "\n");
    }

    private void mostrarMensaje(String mensaje) {
        Label mensajeLabel = new Label(mensaje);
        VBox popupBox = new VBox(mensajeLabel);
        Scene popupScene = new Scene(popupBox, 300, 100);
        Stage popupStage = new Stage();
        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }
}
