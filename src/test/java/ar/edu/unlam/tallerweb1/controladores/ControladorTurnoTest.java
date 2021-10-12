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
        Calendar fecha=Calendar.getInstance();
        fecha.set(2022,10,01,14,00);
        turno=new Turno("Cardiologia", fecha, 32141325L, "Jorge");
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
        Calendar fecha1=Calendar.getInstance();
        fecha1.set(2022,10,01,14,00);
        Turno turno1=new Turno("Cardiologia", fecha1, 32141325L, "Jorge");

        Calendar fecha2=Calendar.getInstance();
        fecha2.set(2022,10,01,14,00);
        Turno turno2=new Turno("Cardiologia", fecha2, 32141925L, "Jorge");

        Calendar fecha3=Calendar.getInstance();
        turno=new Turno("Cardiologia", fecha3, 32141371L, "Jorge");

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
}
