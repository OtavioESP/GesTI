package com.example.api.domain.imagem;

import com.example.api.domain.tarefa.Tarefa;
import jakarta.persistence.*;
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

        @ManyToOne
        @JoinColumn(name = "tarefa_id")
        private Tarefa tarefa;
}
