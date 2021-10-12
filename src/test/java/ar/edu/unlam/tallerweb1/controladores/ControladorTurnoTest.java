package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalendario;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

public class ControladorTurnoTest {
    private ModelAndView mav;
    private Turno turno;
    private ServicioCalendario servicioCalendario=mock(ServicioCalendario.class);
    private ControladorCalendario controladorCalendario=new ControladorCalendario(servicioCalendario);

    @Test
    public void reciboUnTurnoYSeEnviaALaVista(){
        givenSolicitoUnTurno();
        mav=whenSolicitoElTurno(turno);
        thenLoDebeRecibirLaVista(mav);
    }

    private void givenSolicitoUnTurno() {
        Calendar momento=Calendar.getInstance();
        turno=new Turno("Cardiologia", momento, 32141325L, "Jorge");
    }

    private ModelAndView whenSolicitoElTurno(Turno turno) {
        return controladorCalendario.solicitarTurno(turno);
    }

    private void thenLoDebeRecibirLaVista(ModelAndView mav) {
        assertThat(mav.getModel().get("turno")).isEqualTo(turno);
    }
}
