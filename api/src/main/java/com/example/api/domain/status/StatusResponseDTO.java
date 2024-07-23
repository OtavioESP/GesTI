package com.example.api.domain.status;

public record StatusResponseDTO(Integer id, String nome, Integer codigo, String cor) {
    public StatusResponseDTO(Status status) {
        this(status.getId(), status.getNome(), status.getCodigo(), status.getCor());
    }
}
