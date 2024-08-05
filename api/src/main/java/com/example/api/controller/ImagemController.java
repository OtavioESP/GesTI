package com.example.api.controller;

import com.example.api.domain.imagem.Imagem;
import com.example.api.domain.imagem.ImagemRequestDTO;
import com.example.api.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("imagem")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    @PostMapping
    public ResponseEntity<Imagem> create(@RequestBody ImagemRequestDTO body) {
        Imagem newImagem = this.imagemService.createImagem(body);
        return ResponseEntity.ok(newImagem);
    }

}
