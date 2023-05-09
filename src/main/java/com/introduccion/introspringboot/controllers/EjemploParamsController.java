package com.introduccion.introspringboot.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(){

        return "params/index";
    }


    @GetMapping("/string")
    public String param(@RequestParam String texto, Model model){

        model.addAttribute("resultado","El texto enviado es: "+texto);
     //Ejemplo:  en la url se colocaria http://localhost:8080/params/string?texto=Hola que tal
        return "params/ver";
    }

    @GetMapping("/string2")  // podemos colocar un valor por defecto si no llega el parametro y asi no de error o colocar que no es requerido;
    public String param2(@RequestParam (name="texto", required = false, defaultValue = "No llego parametro") String texto, Model model){

        model.addAttribute("resultado","El texto enviado es: "+texto);

        return "params/ver";
    }
    /*OBTENER VARIOS PARAMETROS POR LA URL @RequestParam*/

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero,Model model){
        model.addAttribute("resultado","El texto enviado es: '"+saludo+"'  y el numero es '"+numero+"'");

        return "params/ver";
    }

    /*OTRA FORMA DE RECIVIR VARIOS PARAMETROS*/

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero=null;
        try{
           numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException nfe){
            numero=0;
        }



        model.addAttribute("resultado","El texto enviado es: '"+saludo+"'  y el numero es '"+numero+"'");

        return "params/ver";
    }

}
