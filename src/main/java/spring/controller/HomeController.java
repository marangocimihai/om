package spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    @Value("${spring.application.version}")
    String appVersion;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("appVersion", appVersion);
        return "home";
    }
}