package com.azahartech.planify.servicio;

import com.azahartech.planify.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> listaDeTareas;
    public GestorTareas() {
        this.listaDeTareas = new ArrayList<>();
    }

    /**
     * Añade una nueva tarea a la lista.
     * @param descripcion El texto de la nueva tarea.
     */
    public void anadirTarea(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            System.out.println("-> Error: La descripción de la tarea no puede estar vacía.");
            return;
        }
        Tarea nuevaTarea = new Tarea(descripcion);
        listaDeTareas.add(nuevaTarea);
        System.out.println("-> Tarea añadida con éxito.");
    }

    /**
     * Muestra todas las tareas pendientes y completadas en la consola.
     */
    public void listarTareas() {
        if (listaDeTareas.isEmpty()) {
            System.out.println("-> No tienes ninguna tarea pendiente. ¡Añade una!");
            return;
        }
        System.out.println("\n--- TUS TAREAS ---");
        for (Tarea tarea : listaDeTareas) {
            System.out.println(tarea);
        }
        System.out.println("------------------");
    }
}