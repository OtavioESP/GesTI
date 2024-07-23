package com.example.api.domain.tarefa;

import com.example.api.domain.status.Status;

import java.util.Date;

public record TarefaRequestDTO(String titulo, String descricao, Integer statusId, Date validade) {
}
