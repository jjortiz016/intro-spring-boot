package com.introduccion.introspringboot.controllers;

import com.introduccion.introspringboot.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {
  // va a tener metodos o handler que va manejar las peticiones


    //@RequestMapping(value ="/index", method = RequestMethod.GET)

    /*@GetMapping(value="/index")*/
    @GetMapping({"/index","/"}) // puede ser uno sola ruta
    public String index(Model model){ //tambien se puede utiliza ModelMap
         model.addAttribute("titulo","Hola Spring framework");

        return "index";
    }

    //com Map tambien podemos enviar datos  a la vista
    /*public String index(Map<String, Object> map){
        map.put("titulo","Hola Spring framework con map");

        return "index";
    }*/
    //ModelAndView tambien podemo enviar datos a la vista
    @GetMapping("/home")
    public ModelAndView home(ModelAndView mv){
        mv.addObject("titulo","Hola spring con ModelAndView");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario= new Usuario();
        usuario.setNombre("Martha");
        usuario.setApellido("Lopez");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo","Hola :".concat(usuario.getNombre()));
        return "perfil";
    }

}
