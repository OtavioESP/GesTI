package com.example.api.domain.imagem;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record ImagemRequestDTO(MultipartFile imagem, UUID tarefaId) {
}
