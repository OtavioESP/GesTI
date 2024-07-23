package com.example.api.domain.time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "time")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Time {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
}
