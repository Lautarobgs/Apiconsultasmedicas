package com.lata.turnos.controller;

import com.lata.turnos.dto.TurnoDTO;
import com.lata.turnos.model.Turno;
import com.lata.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoServ;

    @PostMapping("/crear")
    public String crearTurno(@RequestBody TurnoDTO Turno){
        turnoServ.saveTurno(Turno.getFecha(),Turno.getTratamiento(),Turno.getDniPaciente());
        return "ok";
    }
    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return turnoServ.getTurnos();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);
        return "ok";
    }
    @PutMapping("/edit/{id_original}")
    public Turno editTurno(@PathVariable Long id,
                           @RequestBody Turno t){
        turnoServ.editTurno(id,t);
        return turnoServ.findTurno(id);
    }
    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id){
        return turnoServ.findTurno(id);
    }
}
