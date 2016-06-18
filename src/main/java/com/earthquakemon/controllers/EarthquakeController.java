package com.earthquakemon.controllers;

import com.earthquakemon.BashRequestUSGS;
import com.earthquakemon.entities.Earthquake;
import com.earthquakemon.services.EarthquakeService;
import com.earthquakemon.websocket.Brodcaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EarthquakeController implements Brodcaster{

    @Autowired
    EarthquakeService earthquakeService;

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private BashRequestUSGS usgs;

    @Autowired
    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        usgs.setBrodcaster(this);
        usgs.start();
    }

    @RequestMapping("/latest")
    public @ResponseBody List<Earthquake> latest(){
        List<Earthquake> earthquakes = earthquakeService.findAll(35);
        System.out.println(earthquakes.size());
        return earthquakes;
    }

    @RequestMapping("/earthquake/{id}")
    public @ResponseBody Earthquake findById(@PathVariable String id){
        return earthquakeService.findById(id);
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


    @Override
    public void broadcast(String subscribers, Object data) {
        simpMessagingTemplate.convertAndSend(LATEST_EARTHQUAKE, data);
    }
}
