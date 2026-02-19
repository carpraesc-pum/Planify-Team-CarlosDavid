package com.azahartech.planify.modelo;

import com.azahartech.planify.*;


public class Tarea {
    private static int contadorIds = 1; // Variable estática para generar IDs únicos
    private int id;
    private String descripcion;
    private Usuario user;
    private Categoría category;
    private Prioridad priority;
    private boolean completada;

    public Tarea(String descripcion, Usuario user, Categoría category, Prioridad priority, boolean completada) {
        this.id = contadorIds++;
        this.descripcion = descripcion;
        this.completada = false; // Por defecto, una nueva tarea no está completada
        this.user = user;
        this.category = category;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}