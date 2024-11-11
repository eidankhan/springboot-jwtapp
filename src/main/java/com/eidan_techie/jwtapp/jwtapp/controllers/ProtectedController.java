package com.eidan_techie.jwtapp.jwtapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProtectedController {

    @GetMapping("/protected")
    public String callProtected(@RequestParam String param) {
        return  "This is a protected endpoint. Parameter received: " + param;
    }
    
    
}
