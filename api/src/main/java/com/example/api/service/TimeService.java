package com.example.api.service;

import com.example.api.domain.time.Time;
import com.example.api.domain.time.TimeRequestDTO;
import com.example.api.domain.time.TimeResponseDTO;
import com.example.api.domain.time.TimeResponseDetailDTO;
import com.example.api.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public List<TimeResponseDTO> listAllTimes() {
        return this.repository.findAll().stream().map(TimeResponseDTO::new).collect(Collectors.toList());
    }

    public TimeResponseDetailDTO getDetailTime(UUID timeId) {
//        Falta inserir os participantes do time no DTO
        return this.repository.findById(timeId).map(TimeResponseDetailDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Time não encontrado." + timeId));

    }

    public TimeResponseDTO createTime(TimeRequestDTO data) {
        Time newTime = new Time();
        newTime.setNome(data.nome());
        repository.save(newTime);
        return new TimeResponseDTO(newTime);
    }


}
