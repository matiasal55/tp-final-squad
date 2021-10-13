package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RepositorioTurnoTest extends SpringTest {

    private final String ESPECIALIDAD="Cardiologia";
    @Autowired
    private RepositorioCalendario repositorioCalendario;

    @Test
    @Transactional @Rollback
    public void obtenerLosTurnosDeUnaEspecialidad(){
        givenTengoUnaListaDeTurnosDeUnaEspecialidad();
        List<Turno> listaDeTurnos=whenSolicitoLosTurnosDeEsaEspecialidad();
        thenDeberiaTenerUnaListaDeTurnosDeEsaEspecialidad(listaDeTurnos);
    }

    private void givenTengoUnaListaDeTurnosDeUnaEspecialidad() {
        Date fecha1=new Date();
        Turno turno1=new Turno("Cardiologia", 32141325L, "Jorge", fecha1, "14:00");

        Date fecha2=new Date();
        Turno turno2=new Turno("Cardiologia", 32141925L, "Jorge", fecha2, "15:00");

        session().save(turno1);
        session().save(turno2);
    }

    private List<Turno> whenSolicitoLosTurnosDeEsaEspecialidad() {
        return repositorioCalendario.todosLosTurnosDeUnaEspecialidad(ESPECIALIDAD);
    }

    private void thenDeberiaTenerUnaListaDeTurnosDeEsaEspecialidad(List<Turno> listaDeTurnos) {
        assertThat(listaDeTurnos).hasSize(2);
    }

}
