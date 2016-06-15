package com.eathquakemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EarthquakeController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @MessageMapping("/receivedata") // path to receive
    @SendTo("/notification/latest")  // send response to subscribers
    public void receive() throws InterruptedException {
        System.out.println("receiver  method");
    }

}
