package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

import java.util.Date;

public class ControladorTurnoTest {
    private ModelAndView mav;
    private Turno turno;
    private ControladorTurno controladorTurno=new ControladorTurno();

    @Test
    public void reciboUnTurnoYSeEnviaALaVista(){
        givenSolicitoUnTurno();
        mav=whenSolicitoElTurno(turno);
        thenLoDebeRecibirLaVista(mav);
    }

    private void givenSolicitoUnTurno() {
        Date momento=new Date();
        turno=new Turno("Cardiologia", momento, momento);
    }

    private ModelAndView whenSolicitoElTurno(Turno turno) {
        return controladorTurno.solicitarTurno(turno);
    }

    private void thenLoDebeRecibirLaVista(ModelAndView mav) {
        assertThat(mav.getModel().get("turno")).isEqualTo(turno);
    }
}
