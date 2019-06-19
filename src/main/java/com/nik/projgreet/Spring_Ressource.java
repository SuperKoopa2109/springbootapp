package com.nik.projgreet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class Spring_Ressource {
        @RequestMapping("/")
        public String hello() {
            return "Hello World!";
        }
    }

