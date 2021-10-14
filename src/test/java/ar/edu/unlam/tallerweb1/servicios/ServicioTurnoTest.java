package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCalendario;
import org.junit.Test;

import java.util.ArrayList;
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
        Turno turno1=new Turno("Cardiologia", 32141325L, "Jorge", fecha1.toString(), "14:00");

        Date fecha2=new Date();
        Turno turno2=new Turno("Cardiologia", 32141925L, "Jorge", fecha2.toString(), "15:00");

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

    @Test
    public void cuandoReciboUnTurnoMandarloAlRepositorioParaQueLoGuarde(){
        Turno turno=givenReciboUnTurno();
        Long resultado=whenQuieroGuardarElTurno(turno);
        thenDeberiaRecibirUnaConfirmacion(resultado);
    }

    private Turno givenReciboUnTurno() {
        Turno turno=new Turno(ESPECIALIDAD, 32141254L, "Jorge", "2021-11-01","14:00");
        when(repositorioCalendario.guardarTurno(turno)).thenReturn(1L);
        return turno;
    }

    private Long whenQuieroGuardarElTurno(Turno turno) {
        return servicioCalendario.crearUnTurno(turno);
    }

    private void thenDeberiaRecibirUnaConfirmacion(Long resultado) {
        assertThat(resultado).isNotNull();
    }

}
