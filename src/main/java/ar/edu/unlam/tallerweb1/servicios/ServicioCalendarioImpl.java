package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Calendario;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCalendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("servicioCalendario")
@Transactional
public class ServicioCalendarioImpl implements ServicioCalendario{
    private RepositorioCalendario repositorioCalendario;

    @Autowired
    public ServicioCalendarioImpl(RepositorioCalendario repositorioCalendario){
        this.repositorioCalendario=repositorioCalendario;
    }

    @Override
    public ArrayList<Calendario> obtenerCalendarios() {
        return repositorioCalendario.todosLosCalendarios();
    }

    @Override
    public Calendario obtenerUnCalendarioEspecifico(String profesion) throws Exception{
        Calendario calendario=repositorioCalendario.unCalendarioEspecifico(profesion);
        if(calendario == null) throw new Exception();
        return calendario;
    }

    @Override
    public List<Turno> obtenerLosTurnosDeUnaEspecialidad(String especialidad) {
        List<Turno> listaDeTurnos=repositorioCalendario.todosLosTurnosDeUnaEspecialidad(especialidad);
        return listaDeTurnos;
    }

    @Override
    public Long crearUnTurno(Turno turno) {
        Long guardado=repositorioCalendario.guardarTurno(turno);
        return guardado;
    }
}
