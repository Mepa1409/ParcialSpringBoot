package com.example.demo.services;

import com.example.demo.entities.Conferencia;
import com.example.demo.repositories.RepositoryConferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceConferencia {
    @Autowired
    private RepositoryConferencia repositoryConferencia;

    public List<Conferencia> findAll(){

        return repositoryConferencia.findAll();
    }

    public Conferencia findById(Long id ){

        Optional<Conferencia> opt = repositoryConferencia.findById(id);

        return opt.isPresent() ? opt.get() : null;
    }

    public Conferencia save(Conferencia conferencia){

        return repositoryConferencia.save(conferencia);
    }
}
