package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Calendario;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("repositorioCalendario")
public class RepositorioCalendarioImpl implements RepositorioCalendario{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCalendarioImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ArrayList<Calendario> todosLosCalendarios() {
        return (ArrayList<Calendario>) getCurrentSession().createCriteria(Calendario.class).list();
    }

    @Override
    public Calendario unCalendarioEspecifico(String profesion) {
        return (Calendario) getCurrentSession().createCriteria(Calendario.class).add(Restrictions.eq("profesion",profesion)).uniqueResult();
    }

    @Override
    public List<Turno> todosLosTurnosDeUnaEspecialidad(String especialidad) {
        return getCurrentSession().createCriteria(Turno.class).add(Restrictions.eq("especialidad",especialidad)).list();
    }

    @Override
    public Long guardarTurno(Turno turno) {
        return (Long) getCurrentSession().save(turno);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
