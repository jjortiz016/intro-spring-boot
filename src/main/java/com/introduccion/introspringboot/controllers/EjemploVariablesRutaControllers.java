package com.introduccion.introspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaControllers {
   @GetMapping("/")
    public String index(Model model){
       model.addAttribute("titulo", "Enviar  parametros de la ruta @PathVariable");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
   /* public String variables(@PathVariable(name="texto") String textoOtro, Model model){*/
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("titulo", "Recibir parametro de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado es la es:"+texto);

        return "variables/ver";

    }

    @GetMapping("/string/{texto}/{numero}")
    /* public String variables(@PathVariable(name="texto") String textoOtro, Model model){*/
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model){

        model.addAttribute("titulo", "Recibir varios parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta:"+texto+ " y el número enviado en la ruta es: "+numero);

        return "variables/ver";

    }

}
