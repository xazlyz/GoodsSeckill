package org.example.gsk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/businessesman")
public class BusinessesManController {

    @PostMapping
    public String run()
    {
        return "run";
    }

}
