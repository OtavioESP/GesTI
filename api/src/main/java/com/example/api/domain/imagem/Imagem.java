package com.example.api.domain.imagem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "imagem")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Imagem {

        @Id
        @GeneratedValue
        private Integer id;
        private String key;
}
