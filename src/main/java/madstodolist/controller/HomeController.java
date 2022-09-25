package madstodolist.controller;

import madstodolist.authentication.ManagerUserSession;
import madstodolist.controller.exception.UsuarioNoLogeadoException;
import madstodolist.model.Usuario;
import madstodolist.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ManagerUserSession managerUserSession;


    @GetMapping("/about")
    public String about(Model model, HttpSession session) {
        Long idUsuarioLogeado = managerUserSession.usuarioLogeado();

        if(idUsuarioLogeado == null){
            return "redirect:/login";
        }

        Usuario usuario = usuarioService.findById(idUsuarioLogeado);

        model.addAttribute("usuario", usuario);
        model.addAttribute("idLogeado", idUsuarioLogeado);
        return "about";
    }

}