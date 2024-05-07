package com.lata.microservicios.controller;

import com.lata.microservicios.model.Paciente;
import com.lata.microservicios.service.IPacienteService;
import com.lata.microservicios.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService pacienteServ;
    @PostMapping ("/crear")
    public String crearPaciente(@RequestBody Paciente p) { //Lee el cuerpo de la solicitud HTTP
        pacienteServ.savePaciente(p);
        return "ok";
    }
    @GetMapping("/traer")
    public List<Paciente> traerPacientes(){
        return pacienteServ.getPacientes();
    }
    @DeleteMapping("/delete/{id}")
    public void borrarPaciente(@PathVariable Long id){
        pacienteServ.deletePaciente(id);
    }
    @PutMapping ("/edit/{originalId}")
    public Paciente editarPaciente(@PathVariable Long originalId,
                                   @RequestBody Paciente nuevo){
        pacienteServ.editPaciente(originalId,nuevo);
        return pacienteServ.findPaciente(originalId);
    }
    @GetMapping("/traer/{id}")
    public Paciente traerPaciente(@PathVariable Long id){
        return pacienteServ.findPaciente(id);
    }
    @GetMapping("/traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }

}
