package com.example.api.service;

import com.example.api.domain.status.Status;
import com.example.api.domain.tarefa.Tarefa;
import com.example.api.domain.tarefa.TarefaRequestDTO;
import com.example.api.domain.tarefa.TarefaResponseDTO;
import com.example.api.repositories.StatusRepository;
import com.example.api.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Value("${admin.key}")
    private String adminKey;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private StatusRepository statusRepository;

    public TarefaResponseDTO createTarefa(TarefaRequestDTO data) {
        Tarefa newTarefa = new Tarefa();

        Status status = statusRepository.findById(data.statusId()).orElse(null);

        newTarefa.setTitulo(data.titulo());
        newTarefa.setDescricao(data.descricao());
        newTarefa.setStatus(status);
        newTarefa.setValidade(data.validade());
        tarefaRepository.save(newTarefa);
        return new TarefaResponseDTO(newTarefa);
    }

    public List<TarefaResponseDTO> listAllTarefas() {
        return this.tarefaRepository.findAll().stream().map(TarefaResponseDTO::new).collect(Collectors.toList());
    }

    public TarefaResponseDTO getTarefa(UUID tarefaId) {
        return this.tarefaRepository.findById(tarefaId).map(TarefaResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada." + tarefaId));
    }

    public Void deletarTarefa(UUID tarefaId, String adminKey) {
        if (adminKey == null || !adminKey.equals(this.adminKey)) {
            throw new IllegalArgumentException("Permissão inválida.");
        }
        this.tarefaRepository.delete(this.tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada.")));
        return null;
    }

    public TarefaResponseDTO alterarTarefa(UUID tarefaId, TarefaRequestDTO data) {
        Tarefa tarefa = this.tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada."));

        Status status = statusRepository.findById(data.statusId()).orElse(tarefa.getStatus());

        tarefa.setValidade(data.validade() != null ? data.validade() : tarefa.getValidade());
        tarefa.setDescricao(data.descricao() != null ? data.descricao() : tarefa.getDescricao());
        tarefa.setStatus(status);
        tarefa.setTitulo(data.titulo() != null ? data.titulo() : tarefa.getTitulo());
        tarefaRepository.save(tarefa);

        return new TarefaResponseDTO(tarefa);
    }
}
