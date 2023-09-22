package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

@Entity
@Table(name = "conferencias")
public class Conferencia {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "hora_inicio", nullable = false)
        private Date horaInicio;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "hora_fin", nullable = false)
        private Date horaFin;

    @OneToMany(mappedBy = "conferencia", cascade = CascadeType.ALL)
    private List<Evento> events = new ArrayList<>();

    @JsonIgnore


    public Conferencia() {events = new ArrayList<>();}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getHoraInicio() {
            return horaInicio;
        }

        public void setHoraInicio(Date horaInicio) {
            this.horaInicio = horaInicio;
        }

        public Date getHoraFin() {
            return horaFin;
        }

        public void setHoraFin(Date horaFin) {
            this.horaFin = horaFin;
        }


    public void addEvent( Evento evento ){
        events.add(evento);
    }
}



