package com.eathquakemon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EarthQuakeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
