package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalendario;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ControladorTurnoTest {
    private static final String ESPECIALIDAD = "Cardiologia";
    private ModelAndView mav;
    private Turno turno;
    private List<Turno> listaDeTurnos=new ArrayList<>();
    private ServicioCalendario servicioCalendario=mock(ServicioCalendario.class);
    private ControladorCalendario controladorCalendario=new ControladorCalendario(servicioCalendario);

    @Test
    public void reciboUnTurnoYSeEnviaALaVista(){
        givenSolicitoUnTurno();
        mav=whenSolicitoElTurno(turno);
        thenLoDebeRecibirLaVista(mav);
    }

    private void givenSolicitoUnTurno() {
        String fecha="2021-10-01";
        turno=new Turno("Cardiologia", 32141325L, "Jorge", fecha, "14:00");
        when(servicioCalendario.crearUnTurno(turno)).thenReturn(1L);
    }

    private ModelAndView whenSolicitoElTurno(Turno turno) {
        return controladorCalendario.solicitarTurno(turno);
    }

    private void thenLoDebeRecibirLaVista(ModelAndView mav) {
        assertThat(mav.getModel().get("turno")).isEqualTo(turno);
    }

    @Test
    public void reciboUnaListaDeTurnosDeUnaEspecialidad() throws Exception {
        givenTengoUnaListaDeTurnosDeUnaEspecialidad();
        mav=whenSolicitoLaListaDeTurnosDeEsaespecialidad();
        thenDeberiaVerEsaLista(mav);
    }

    private void givenTengoUnaListaDeTurnosDeUnaEspecialidad() {
        Date fecha1=new Date();
        Turno turno1=new Turno("Cardiologia", 32141325L, "Jorge", fecha1.toString(), "14:00");

        Date fecha2=new Date();
        Turno turno2=new Turno("Cardiologia", 32141925L, "Jorge", fecha2.toString(), "15:00");

        Date fecha3=new Date();
        turno=new Turno("Cardiologia", 32141371L, "Jorge", fecha3.toString(), "16:00");

        listaDeTurnos.add(turno1);
        listaDeTurnos.add(turno2);
        listaDeTurnos.add(turno);

        when(servicioCalendario.obtenerLosTurnosDeUnaEspecialidad(ESPECIALIDAD)).thenReturn(listaDeTurnos);
    }

    private ModelAndView whenSolicitoLaListaDeTurnosDeEsaespecialidad() throws Exception {
        return controladorCalendario.recibirUnaEspecialidad(ESPECIALIDAD);
    }

    private void thenDeberiaVerEsaLista(ModelAndView mav) {
        assertThat(mav.getModel().get("turnos")).isEqualTo(listaDeTurnos);
        List<Turno> turnos= (List<Turno>) mav.getModel().get("turnos");
        assertThat(turnos).contains(turno);
        assertThat(turnos).hasSize(3);
    }

    @Test
    public void recibirUnTurnoYEnviarloAlServicioParaQueLoGuarde(){
        givenSolicitoUnTurno();
        mav=whenGuardoElTurno();
        thenDeberiaVerQueSeGuardo(mav);
    }

    private ModelAndView whenGuardoElTurno() {
        return controladorCalendario.solicitarTurno(turno);
    }

    private void thenDeberiaVerQueSeGuardo(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("confirmacion");
    }
}
