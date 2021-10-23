package com.foorder.health;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/health")
public class HealthCheck {

    @GetMapping("")
    public Object getHealth(){
        HashMap<String, Boolean> result = new HashMap<>();
        result.put("alive", true);
        return result;
    }
}
