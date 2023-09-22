package com.example.demo.repositories;

import com.example.demo.entities.Conferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryConferencia extends JpaRepository<Conferencia, Long> {
}
