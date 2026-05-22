package com.turnos.demo.Repository;

import com.turnos.demo.Model.TurnoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/*
Si bien es una clase vacia, no debo olvidar que al decir "extends" estoy diciendo que mi clase extiende del repositorio
del Jpa, quiere decir que hereda sus funcionalidades, tales como: guardar, findById, findAll, deleteById.

Por otro lado no debo olvidarme que el ORM (En mi caso el hibernate) es el que se encarga de traducir codigo Java al
"idioma" de la base de datos.

Justamente por eso estoy usando un interfaz porque es un mapa del como lo quiero hacer, al decir que mi clase extiende del Jpa
Spring se estaria encargando del resto.
*/


public interface TurnoRepository extends  JpaRepository<TurnoModel, Long> {

    List<TurnoModel> findByFechaTurno(LocalDate fecha);

    boolean existsByFechaTurnoAndHoraTurno(LocalDate fechaTurno, LocalTime horaTurno);

}
