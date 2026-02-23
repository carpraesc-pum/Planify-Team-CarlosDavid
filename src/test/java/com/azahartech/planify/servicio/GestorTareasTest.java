package com.azahartech.planify.servicio;

import com.azahartech.planify.Categoría;
import com.azahartech.planify.Prioridad;
import com.azahartech.planify.modelo.Tarea;
import com.azahartech.planify.modelo.Usuario;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.*;

class GestorTareasTest {

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