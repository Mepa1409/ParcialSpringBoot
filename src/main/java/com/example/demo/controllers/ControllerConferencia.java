package com.example.demo.controllers;

import com.example.demo.entities.Conferencia;
import com.example.demo.responses.ResponseHandler;
import com.example.demo.services.ServiceConferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Conferences")
public class ControllerConferencia {
    @Autowired
    private ServiceConferencia serviceConferencia;

    @GetMapping
    public ResponseEntity<Object> findAll() {

        try {
            List<Conferencia> result = serviceConferencia.findAll();

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Conferencia conferencia){
        try{
            Conferencia conferencia1 = serviceConferencia.save(conferencia);

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, conferencia1);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        try{
            Conferencia conferencia = serviceConferencia.findById( id );

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, conferencia);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
