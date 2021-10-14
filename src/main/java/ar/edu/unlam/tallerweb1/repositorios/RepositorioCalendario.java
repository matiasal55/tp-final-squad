package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Calendario;
import ar.edu.unlam.tallerweb1.modelo.Turno;

import java.util.ArrayList;
import java.util.List;

public interface RepositorioCalendario {
    ArrayList<Calendario> todosLosCalendarios();

    Calendario unCalendarioEspecifico(String profesion);

    List<Turno> todosLosTurnosDeUnaEspecialidad(String especialidad);

    Long guardarTurno(Turno turno);
}
