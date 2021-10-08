package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class ControladorTurno {

    @RequestMapping(path = "/calendarios/solicitar-turno", method = RequestMethod.POST)
    public ModelAndView solicitarTurno(@RequestParam Turno turno) {
        ModelMap model=new ModelMap();
        model.put("turno", turno);
        return new ModelAndView("calendarios", model);
    }
}
