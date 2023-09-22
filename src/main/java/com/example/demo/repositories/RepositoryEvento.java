package com.example.demo.repositories;

import com.example.demo.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEvento extends JpaRepository<Evento, String> {

}
