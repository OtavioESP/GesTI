package com.example.api.service;

import com.example.api.domain.status.Status;
import com.example.api.domain.tarefa.Tarefa;
import com.example.api.domain.tarefa.TarefaRequestDTO;
import com.example.api.domain.tarefa.TarefaResponseDTO;
import com.example.api.repositories.StatusRepository;
import com.example.api.repositories.TarefaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private StatusRepository statusRepository;

    public Tarefa createTarefa(TarefaRequestDTO data) {
        Tarefa newTarefa = new Tarefa();

        Status status = statusRepository.findById(data.statusId()).orElse(null);

        newTarefa.setTitulo(data.titulo());
        newTarefa.setDescricao(data.descricao());
        newTarefa.setStatus(status);
        newTarefa.setValidade(data.validade());
        tarefaRepository.save(newTarefa);
        return newTarefa;
    }

    public List<TarefaResponseDTO> listAllTarefas() {
        return this.tarefaRepository.findAll().stream().map(TarefaResponseDTO::new).collect(Collectors.toList());
    }

    public TarefaResponseDTO getTarefa(UUID tarefaId) {
        return this.tarefaRepository.findById(tarefaId).map(TarefaResponseDTO::new).orElseThrow(() -> new RuntimeException("Tarefa não encontrada." + tarefaId));
    }

    public void alterTarefa(TarefaRequestDTO data) {

    }
}
