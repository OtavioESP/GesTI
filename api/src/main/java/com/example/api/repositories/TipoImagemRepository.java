package com.example.api.repositories;

import com.example.api.domain.tipoimagem.TipoImagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoImagemRepository  extends JpaRepository<TipoImagem, Integer> {
}
