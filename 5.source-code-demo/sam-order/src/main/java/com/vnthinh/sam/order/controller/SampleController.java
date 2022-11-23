package com.vnthinh.sam.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/sam")
public class SampleController {

    @Value("${profile.name:null}")
    private String profile;

    @GetMapping("/greeting")
    public ResponseEntity<Object> greeting(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return new ResponseEntity<>("Hello " + name + "!!", HttpStatus.OK);
    }

    @GetMapping("/check-profile")
    public ResponseEntity<Object> checkProfileEnable() {
        return new ResponseEntity<>("Active profile: " +profile, HttpStatus.OK);
    }

    @GetMapping("/delay")
    public ResponseEntity<Object> delayApi(@RequestParam(value = "delay", defaultValue = "0") Integer delay) throws InterruptedException {
        if(delay == 0) {
            Random random = new Random();
            delay = random.nextInt(10);
        }
        TimeUnit.SECONDS.sleep(delay);
        return new ResponseEntity<>("Delay after " +delay +"s", HttpStatus.OK);
    }

}
