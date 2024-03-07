package com.portafolio.portafolioWEB.controllers;

import com.portafolio.portafolioWEB.exceptions.CorreoExceptions;
import com.portafolio.portafolioWEB.servicios.CorreoServicios;
import javax.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CorreoController {

    CorreoServicios correoServicios = new CorreoServicios();

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @PostMapping("/enviar-formulario")
    public String procesarFormulario(@RequestParam String nombre, @RequestParam String emailReclutador, @RequestParam String asunto, @RequestParam String comentario, ModelMap model) throws MessagingException {
        try {
            correoServicios.crearCorreo(nombre, emailReclutador, asunto, comentario);
            model.put("exito", "Gracias por contactarte conmigo, " + nombre + ". Te respondere en breve.");
            return "index";

        } catch (CorreoExceptions ex) {
            model.put("error", ex.getMessage());
            return "index";
        }
    }
}
