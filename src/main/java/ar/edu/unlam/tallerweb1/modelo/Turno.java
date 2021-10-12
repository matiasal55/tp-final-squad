package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String especialidad;
    private Calendar fechaYHora;
    private Long documento;
    private String especialista;

    public Turno(String especialidad, Calendar fechaYHora, Long documento, String especialista) {
        this.especialidad = especialidad;
        this.fechaYHora = fechaYHora;
        this.documento = documento;
        this.especialista = especialista;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Calendar getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Calendar fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }
}
