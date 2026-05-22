package com.turnos.demo.Controller;

import com.turnos.demo.Model.TurnoModel;
import com.turnos.demo.Service.TurnoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController                  //Se vana ubicar las HTTP
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService; //Estoy usando el turnoService que ya existe basicamente


    public TurnoController(TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @PostMapping //Operacion POST
    public TurnoModel crearTurno(@RequestBody TurnoModel turno){ //RequestBody me transforma el JSON en el objeto
        return turnoService.guardarTurno(turno);
    }

    @GetMapping
    public List<TurnoModel> getTurnos(){
        return turnoService.obtenerTurnos();
    }

    @GetMapping("/fecha/{fecha}")
    public List<TurnoModel> obtenerTurnosPorFecha(@PathVariable LocalDate fecha){
        return turnoService.obtenerTurnosPorFecha(fecha);
    }

}
