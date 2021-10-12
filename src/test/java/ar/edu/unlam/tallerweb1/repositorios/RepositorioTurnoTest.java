package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
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
        Calendar fecha1=Calendar.getInstance();
        fecha1.set(2022,10,01,14,00);
        Turno turno1=new Turno("Cardiologia", fecha1, 32141325L, "Jorge");

        Calendar fecha2=Calendar.getInstance();
        fecha2.set(2022,10,01,15,00);
        Turno turno2=new Turno("Cardiologia", fecha2, 32141925L, "Jorge");

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
