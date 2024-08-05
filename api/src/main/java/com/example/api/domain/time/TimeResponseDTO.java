package com.example.api.domain.time;

import com.example.api.domain.usuario.Usuario;

import java.util.List;
import java.util.UUID;

public record TimeResponseDTO(UUID id, String nome) {
    public TimeResponseDTO(Time time) {
        this(time.getId(), time.getNome());
    }
}
//, List<Usuario> usuarios
// this(usuarios)