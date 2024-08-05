package com.example.api.domain.time;

import java.util.UUID;

public record TimeResponseDetailDTO(UUID id, String nome) {
    public TimeResponseDetailDTO(Time time) {
        this(time.getId(), time.getNome());
    }
}
