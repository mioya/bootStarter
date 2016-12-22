package com.mio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "sprinag boot from");
        return "index";
    }
}
