package com.turnos.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.time.LocalDate;

@Entity
@Table(name = "turno")
public class TurnoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La base de datos gestiona la creacion de ids.
    private Long id;

    @Column(name = "nombre_paciente")
    private String nombrePaciente;
    @Column(name = "apellido_paciente")
    private String apellidoPaciente;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_turno")
    private LocalDate fechaTurno;
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_turno")
    private LocalTime horaTurno;

    //Constructor vacio
    public TurnoModel(){

    }

    //Constructor completo con parametros
    public TurnoModel(String nombrePaciente, String apellidoPaciente, LocalDate fechaTurno, LocalTime horaTurno){
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
    }


    //Getters y Setters
    public Long getId(){
        return id;
    }

    //Get y Set del paciente
    public String getNombrePaciente(){
        return  nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente){
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente(){
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente){
        this.apellidoPaciente = apellidoPaciente;
    }

    //Get y Set de la fecha
    public LocalDate getFechaTurno(){
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno){
        this.fechaTurno = fechaTurno;
    }

    //Get y Set de la hora
    public LocalTime getHoraTurno(){
        return horaTurno;
    }

    public void setHoraTurno(LocalTime horaTurno){
        this.horaTurno = horaTurno;
    }



}
