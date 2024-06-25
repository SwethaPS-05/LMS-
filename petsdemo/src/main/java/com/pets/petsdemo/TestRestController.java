package com.pets.petsdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestRestController {

    @RequestMapping(value ="/test")
    public String getCities() {
        return "index.html";
    }
}
