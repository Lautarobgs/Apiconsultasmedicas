package com.lata.microservicios.service;

import com.lata.microservicios.model.Paciente;

import java.util.List;

public interface IPacienteService {
     List<Paciente> getPacientes();
     void savePaciente(Paciente p);
     void deletePaciente(Long id);
     Paciente findPaciente(Long id);
     void editPaciente(Long id, Paciente p);
     Paciente findPacientebyId(Long id);

     Paciente findPacienteDni(String dni);
}
