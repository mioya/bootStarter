package com.base.controller;

import com.base.entity.User;
import com.base.repository.UserRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@CommonsLog
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList",userList);
        return "user/list";
    }

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
