package com.example.api.domain.time;

import com.example.api.domain.usuario.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public record TimeRequestDTO(UUID id, String nome, Optional<List<Usuario>> participantes) {
}
