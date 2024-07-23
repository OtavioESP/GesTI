package com.example.api.controller;

import com.amazonaws.Response;
import com.example.api.domain.tarefa.Tarefa;
import com.example.api.domain.tarefa.TarefaRequestDTO;
import com.example.api.domain.tarefa.TarefaResponseDTO;
import com.example.api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@RequestBody TarefaRequestDTO body) {
        Tarefa newTarefa = this.tarefaService.createTarefa(body);
        return ResponseEntity.ok(newTarefa);
    }

    @GetMapping("/{tarefaId}")
    public ResponseEntity<TarefaResponseDTO> getTarefa(@PathVariable UUID tarefaId) {
        TarefaResponseDTO tarefa = this.tarefaService.getTarefa(tarefaId);
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TarefaResponseDTO>> listAllTarefas() {
        List<TarefaResponseDTO> allTarefas = this.tarefaService.listAllTarefas();
        return ResponseEntity.ok(allTarefas);
    }
}
