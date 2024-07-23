package com.example.api.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.api.domain.status.StatusResponseDTO;
import com.example.api.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {

    @Autowired
    private StatusRepository repository;

    public List<StatusResponseDTO> listAllStatus() {
       return this.repository.findAll().stream().map(StatusResponseDTO::new).collect(Collectors.toList());
    }

    public StatusResponseDTO getStatus(Integer statusId) {
        return this.repository.findById(statusId).map(StatusResponseDTO::new).orElseThrow(() -> new RuntimeException("Status não encontrada." + statusId));
    }
}
