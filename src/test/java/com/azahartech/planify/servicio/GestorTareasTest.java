package com.azahartech.planify.servicio;

import com.azahartech.planify.Categoría;
import com.azahartech.planify.Prioridad;
import com.azahartech.planify.modelo.Tarea;
import com.azahartech.planify.modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTareasTest {

    private GestorTareas gestor;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setUp() {
        gestor = new GestorTareas();

        usuario1 = new Usuario("Ana", "admin");
        usuario2 = new Usuario("Carlos", "user");

        gestor.anadirTarea("Estudiar Java Streams",  usuario1, Categoría.ESTUDIO,  Prioridad.ALTA,  false);
        gestor.anadirTarea("Comprar leche",           usuario2, Categoría.PERSONAL, Prioridad.BAJA,  false);
        gestor.anadirTarea("Reunión de equipo",       usuario1, Categoría.TRABAJO,  Prioridad.ALTA,  false);
        gestor.anadirTarea("Hacer ejercicio",         usuario2, Categoría.SALUD,    Prioridad.MEDIA, false);
        gestor.anadirTarea("Repasar apuntes de PROP", usuario1, Categoría.ESTUDIO,  Prioridad.MEDIA, false);
    }


    // ── filtrarPorUsuario ───────────────────────────────────────────────────

    @Test
    void filtrarPorUsuario_usuario1_tresTareas() {
        List<Tarea> resultado = gestor.filtrarPorUsuario(usuario1);
        assertEquals(3, resultado.size());
    }

    @Test
    void filtrarPorUsuario_usuario2_dosTareas() {
        List<Tarea> resultado = gestor.filtrarPorUsuario(usuario2);
        assertEquals(2, resultado.size());
    }

    @org.junit.jupiter.api.Test
    void anadirUsuario() {
        GestorTareas user = new GestorTareas();
        user.anadirUsuario("Salvation", "Manager");
        assertEquals(1,user.getSetDeUsuarios().size());
    }

    @Test
    void anadirTarea() {
        GestorTareas gestorTareas = new GestorTareas();
        gestorTareas.anadirTarea("Descripción", new Usuario("Paquito", "Manager"), Categoría.BUG, Prioridad.MEDIA, true);
        assertEquals(1, gestorTareas.getListaDeTareas().size());
    }

}