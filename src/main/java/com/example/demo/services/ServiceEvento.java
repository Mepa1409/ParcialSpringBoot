package com.example.demo.services;

import com.example.demo.entities.Conferencia;
import com.example.demo.entities.Evento;
import com.example.demo.repositories.RepositoryConferencia;
import com.example.demo.repositories.RepositoryEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEvento {

    @Autowired
    private RepositoryEvento repositoryEvento;

    @Autowired
    private RepositoryConferencia repositoryConferencia;

    public List<Evento> getEventos() {
        return repositoryEvento.findAll();
    }

    public Evento findEventoById(Long id) {

        Optional<Evento> optionalEvento = repositoryEvento.findById(String.valueOf(id));

        return optionalEvento.isPresent() ? optionalEvento.get() : null;
    }

    public Evento saveEventoWithConferencia(Evento evento, Long conferenciaId) {

        Optional<Conferencia> optionalConferencia = repositoryConferencia.findById(conferenciaId);

        Conferencia conferencia = optionalConferencia.orElse(null);
        if (conferencia != null) {
            evento.setConferencia(conferencia);
            conferencia.addEvent(evento);

            return repositoryEvento.save(evento);
        }

        return null;
    }

    public Evento deleteEvento(Long id) {

        Evento evento = findEventoById(id);

        if (evento != null) {
            repositoryEvento.delete(evento);
        }

        return evento;
    }
}
