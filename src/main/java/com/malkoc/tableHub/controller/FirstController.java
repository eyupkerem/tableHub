package com.malkoc.tableHub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FirstController {

    @GetMapping("/hello")
    private String first(){
        return "TABLE HUB";
    }

}
