package com.base.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
public class UserController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "sprinag boot from");
        return "index";
    }
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("test", "test");
        return "index";
    }
}
