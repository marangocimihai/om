package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.config.OwnerConfigProperties;

@Controller
@RequestMapping(path = "/om")
public class EmployeeController {
    private OwnerConfigProperties ocp;

    @Autowired
    public void setOcp(OwnerConfigProperties ocp) {
        this.ocp = ocp;
    }

    @GetMapping(path = "/home")
    public String home(Model model) {
        model.addAttribute("name", ocp.getName());
        model.addAttribute("surname", ocp.getSurname());
        model.addAttribute("mail", ocp.getMail());
        return "home";
    }

    @GetMapping(path = "/signin")
    public String signin(Model model) {
        return "signin";
    }

    @GetMapping(path = "/signup")
    public String signup(Model model) {
        return "signup";
    }
}
