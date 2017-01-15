package com.base.controller;

import com.base.entity.User;
import com.base.repository.UserRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String save(@Validated User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return list(model);
        }
        userRepository.save(user);
        return "user/save";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    @ResponseBody
    public String update(@PathVariable String userId, @RequestBody User user){
        User oldUser = userRepository.getOne(userId);
        if(oldUser != null){
            userRepository.save(user);
        }
        return "user/update";
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "sprinag boot from");
        return "index";
    }

}
