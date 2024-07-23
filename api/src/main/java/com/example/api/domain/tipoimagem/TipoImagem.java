package com.example.api.domain.tipoimagem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tipo_imagem")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoImagem {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer codigo;
    private String nome;

}
