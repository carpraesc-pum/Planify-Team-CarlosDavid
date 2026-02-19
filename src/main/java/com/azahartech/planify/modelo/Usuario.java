package com.azahartech.planify.modelo;

import java.util.Objects;

public class Usuario {
    private String name;
    private String type;

    public Usuario(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario usuario)) return false;
        return Objects.equals(name, usuario.name) && Objects.equals(type, usuario.type);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type;
    }
}
