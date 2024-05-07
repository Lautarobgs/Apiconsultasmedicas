package com.lata.turnos.service;

import com.lata.turnos.model.Paciente;
import com.lata.turnos.model.Turno;
import com.lata.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    private ITurnoRepository turnoRepo;
    @Autowired
    private RestTemplate apiConsumir;
    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        ///Buscar paciente en la api de pacientes
        ///    /traerdni/{dni}
        Paciente p = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente
                                                ,Paciente.class);
        String nombreCompletoPaciente = p.getNombre() + " " + p.getApellido();
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);

        turnoRepo.save(turno);

    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno turn = this.findTurno(id);
        turn.setFecha(turno.getFecha());
        turn.setTratamiento(turno.getTratamiento());
        turn.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        turnoRepo.save(turn);
    }
}
