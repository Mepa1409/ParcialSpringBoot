package com.example.demo.controllers;

import com.example.demo.entities.Evento;
import com.example.demo.services.ServiceEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conferencias")
public class ControllerEvento {
    @Autowired
    private ServiceEvento serviceEvento;

    @GetMapping
    public List<Evento> getEvents(){
        return serviceEvento.getEventos();
    }

    @GetMapping("/{id}")
    public Evento findById(@PathVariable String id){

        return serviceEvento.findEventoById(Long.valueOf(id));
    }

    @PostMapping("/{id}")
    public Evento save(@RequestBody Evento evento, @PathVariable Long id){
        if( serviceEvento.findEventoById(evento.getId())== null ){
            return serviceEvento.saveEventoWithConferencia(evento,id);
        }

        return null;
    }
}
