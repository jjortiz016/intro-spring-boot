package com.introduccion.introspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String home(){
       return "forward:/app/index"; //ejecuta RequestDispatcher.forward() no cambia la ruta como el redirect
    }

}
