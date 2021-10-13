package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCalendario;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServicioTurnoTest {
    private final String ESPECIALIDAD="Cardiologia";
    private RepositorioCalendario repositorioCalendario=mock(RepositorioCalendario.class);
    private ServicioCalendario servicioCalendario=new ServicioCalendarioImpl(repositorioCalendario);

    @Test
    public void obtenerUnaListaDeTurnosDeUnaEspecialidad(){
        givenSolicitoLosTurnosDeUnaEspecialidad();
        List<Turno> listaDeTurnos=whenPidoLosTurnosDeEsaEspecialidad();
        thenDeberiaVerLaListaDeTurnosPedida(listaDeTurnos);
    }

    private void givenSolicitoLosTurnosDeUnaEspecialidad() {
        List<Turno> listaDeTurnos=new ArrayList<>();

        Date fecha1=new Date();
        Turno turno1=new Turno("Cardiologia", 32141325L, "Jorge", fecha1, "14:00");

        Date fecha2=new Date();
        Turno turno2=new Turno("Cardiologia", 32141925L, "Jorge", fecha2, "15:00");

        listaDeTurnos.add(turno1);
        listaDeTurnos.add(turno2);

        when(repositorioCalendario.todosLosTurnosDeUnaEspecialidad(ESPECIALIDAD)).thenReturn(listaDeTurnos);
    }

    private List<Turno> whenPidoLosTurnosDeEsaEspecialidad() {
        return servicioCalendario.obtenerLosTurnosDeUnaEspecialidad(ESPECIALIDAD);
    }

    private void thenDeberiaVerLaListaDeTurnosPedida(List<Turno> listaDeTurnos) {
        assertThat(listaDeTurnos).hasSize(2);
    }

}
