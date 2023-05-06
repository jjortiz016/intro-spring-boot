package com.introduccion.introspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
  // va a tener metodos o handler que va manejar las peticiones


    //@RequestMapping(value ="/index", method = RequestMethod.GET)

    /*@GetMapping(value="/index")*/
    @GetMapping({"/index","/","home"}) // puede ser uno sola ruta
    public String index(){


        return "index";
    }
}
