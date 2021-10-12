package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Calendar;

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

    public Turno() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
