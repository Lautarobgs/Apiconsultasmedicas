package com.lata.turnos.service;

import com.lata.turnos.model.Turno;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITurnoService {
     List<Turno> getTurnos();
     void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);
     void deleteTurno(Long id);
     Turno findTurno(Long id);
     void editTurno(Long id, Turno turno);


}
