package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Calendario;
import ar.edu.unlam.tallerweb1.modelo.Turno;

import java.util.ArrayList;
import java.util.List;

public interface ServicioCalendario {
    ArrayList<Calendario> obtenerCalendarios();

    Calendario obtenerUnCalendarioEspecifico(String profesion) throws Exception;

    List<Turno> obtenerLosTurnosDeUnaEspecialidad(String especialidad);

    Long crearUnTurno(Turno turno);
}
