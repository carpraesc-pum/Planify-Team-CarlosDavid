package com.azahartech.planify.servicio;

import com.azahartech.planify.Categoría;
import com.azahartech.planify.Prioridad;
import com.azahartech.planify.modelo.Usuario;
import com.azahartech.planify.modelo.Tarea;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//list de tareas H
//set de usuarios H
//Utilizando los genéricos
//Método agregarUsuario para añadir un usuario

public class GestorTareas {
    private List<Tarea> listaDeTareas;
    private Set<Usuario> setDeUsuarios;
    public GestorTareas() {
        this.listaDeTareas = new ArrayList<>();
        this.setDeUsuarios = new HashSet<>();
    }

    public Set<Usuario> getSetDeUsuarios() {
        return setDeUsuarios;
    }

    public List<Tarea> getListaDeTareas() {
        return listaDeTareas;
    }

    public void anadirUsuario(String name, String type) {
        Usuario usuarioNuevo = new Usuario(name, type);
        setDeUsuarios.add(usuarioNuevo);
        System.out.println(". . . Usuario añadido con éxito . . . ");
    }

    /**
     * Añade una nueva tarea a la lista.
     * @param descripcion El texto de la nueva tarea.
     */
    public void anadirTarea(String descripcion, Usuario user, Categoría category, Prioridad priority, boolean completada) {
        Tarea nuevaTarea = new Tarea(descripcion, user, category, priority, completada);
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
    public List<Tarea> filtrarPorUsuario(Usuario usuario) {
        return listaDeTareas.stream()
                .filter(tarea -> tarea.getUser().equals(usuario))
                .collect(Collectors.toList());
    }
    public List<Tarea> getTareasPendientes() {
        return listaDeTareas.stream()
                .filter(tarea -> !tarea.isCompletada())
                .collect(Collectors.toList());
    }
    public void marcarTareaComoCompletada(int id) {
        for (Tarea tarea : listaDeTareas) {
            if (tarea.getId() == id) {
                if (tarea.isCompletada()) {
                    System.out.println("-> La tarea #" + id + " ya estaba completada.");
                } else {
                    tarea.setCompletada(true);
                    System.out.println("-> ¡Bien hecho! Tarea #" + id + " marcada como completada.");
                }
                return; // Salimos del método una vez encontrada la tarea
            }
        }
        // Si el bucle termina, la tarea no fue encontrada
        System.out.println("-> Error: No se encontró ninguna tarea con el ID " + id + ".");
    }

}