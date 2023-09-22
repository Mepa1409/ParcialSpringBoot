package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "events")
public class Evento {

    @ManyToOne
    @JoinColumn(name = "ref_conferencia", nullable = false)
    private Conferencia conferencia;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_event")
    private String nombre;

    @Column(name = "fecha_event")
    private LocalDate dateevent;

    @Column(name = "lugar")
    private String lugar;





    public Evento(String nombre, LocalDate dateevent, String lugar) {
        this.nombre = nombre;
        this.dateevent = dateevent;
        this.lugar = lugar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getDateevent() {
        return dateevent;
    }

    public void setDateevent(LocalDate dateevent) {
        this.dateevent = dateevent;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }




    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha_event=" + dateevent +
                ", lugar='" + lugar + '\'' +
                '}';
    }



    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia author) {
        this.conferencia = conferencia;
    }
}
