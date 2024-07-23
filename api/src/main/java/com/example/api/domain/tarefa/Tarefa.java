package com.example.api.domain.tarefa;


import com.example.api.domain.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "tarefa")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue
    private UUID id;

    private String titulo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    private Date validade;

}
