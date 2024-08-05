package com.example.api.domain.usuario;

public enum UsuarioRoles {
    ADMIN("adin"),
    USER("user");

    private String role;

    UsuarioRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
