package com.turnos.demo.Service;

import com.turnos.demo.Model.TurnoModel;
import com.turnos.demo.Repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service //Estoy indicando que tengo la logica de negocios aca
public class TurnoService {

    private TurnoRepository turnoRepository; //Estoy usando el repositorio existente, no creandolo

    public TurnoService(TurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }

    /*
    Recibo una entidad turno, llamo al repositorio y este lo envia a la base, devuelvo el resultado.
    */
    public TurnoModel guardarTurno(TurnoModel turno){

        boolean existe = turnoRepository.existsByFechaTurnoAndHoraTurno(turno.getFechaTurno(), turno.getHoraTurno());
        if(existe){
            throw new RuntimeException("Ya existe un turno en esa fecha y hora");
        }

        return turnoRepository.save(turno);
    }


    public List<TurnoModel> obtenerTurnos(){
        return turnoRepository.findAll();
    }


    public List<TurnoModel> obtenerTurnosPorFecha(LocalDate fecha){
        return turnoRepository.findByFechaTurno(fecha);
    }

}
