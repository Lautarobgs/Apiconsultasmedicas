package com.lata.microservicios.service;

import com.lata.microservicios.model.Paciente;
import com.lata.microservicios.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private IPacienteRepository pacRepo;
    @Override
    public List<Paciente> getPacientes() {
        return pacRepo.findAll();
    }

    @Override
    public void savePaciente(Paciente p) {
        pacRepo.save(p);
    }

    @Override
    public void deletePaciente(Long id) {
        pacRepo.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacRepo.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Long id, Paciente p) {
        this.savePaciente(p);
    }

    @Override
    public Paciente findPacientebyId(Long id) {
        return null;
    }

    @Override
    public Paciente findPacienteDni(String dni) {
        return pacRepo.findByDni(dni);
    }
}
