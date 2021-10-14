package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Calendario;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalendario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorCalendario {
    private ServicioCalendario servicioCalendario;

    @Autowired
    public ControladorCalendario(ServicioCalendario servicioCalendario){
        this.servicioCalendario=servicioCalendario;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping("/home")
    public ModelAndView irAHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/calendarios", method = RequestMethod.GET)
    public ModelAndView verTodosLosCalendarios() {
        ModelMap model=new ModelMap();
        String titulo="Todos";
        ArrayList<Calendario> calendarios=servicioCalendario.obtenerCalendarios();
        model.put("calendarios",calendarios);
        model.put("titulo", titulo);
        return new ModelAndView("listaDeEspecialidades", model);
    }

    @RequestMapping(path = "/calendarios", method = RequestMethod.POST)
    public ModelAndView recibirUnaEspecialidad(@RequestParam(required = false) String especialidad) throws Exception {
        ModelMap model=new ModelMap();
        try {
            String titulo = especialidad;
            Calendario unSoloCalendario=servicioCalendario.obtenerUnCalendarioEspecifico(especialidad);
            ArrayList<Calendario> calendarios=servicioCalendario.obtenerCalendarios();
            List<Turno> turnos=servicioCalendario.obtenerLosTurnosDeUnaEspecialidad(especialidad);
            model.put("calendario", unSoloCalendario);
            model.put("calendarios",calendarios);
            model.put("titulo", titulo);
            model.put("turnos", turnos);
            model.put("turno", new Turno());
            return new ModelAndView("calendarios", model);
        } catch (Exception e) {
            return new ModelAndView("error", model);
        }
    }

    @RequestMapping(path = "/solicitar-turno", method = RequestMethod.POST)
    public ModelAndView solicitarTurno(@ModelAttribute("turno") Turno turno) {
        ModelMap model=new ModelMap();
        Long confirmacion=servicioCalendario.crearUnTurno(turno);
        if(confirmacion!=null){
            model.put("turno", turno);
            return new ModelAndView("confirmacion", model);
        }
        return new ModelAndView("error");
    }
}
