package com.example.api.repositories;

import com.example.api.domain.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeRepository extends JpaRepository<Time, UUID> {
}
