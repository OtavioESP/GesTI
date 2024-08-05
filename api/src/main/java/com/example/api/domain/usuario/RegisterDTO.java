package com.example.api.domain.usuario;

public record RegisterDTO(String login, String password, UsuarioRoles role) {
}
