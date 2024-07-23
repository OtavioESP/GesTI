package com.example.api.domain.tarefa;

import com.example.api.domain.status.Status;

import java.util.Date;
import java.util.UUID;

public record TarefaResponseDTO(UUID id, String titulo, String descricao, Status status, Date validade) {
    public TarefaResponseDTO(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getValidade());
    }
}
