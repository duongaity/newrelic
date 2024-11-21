package com.duong.newrelic.controller;

import com.duong.newrelic.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/numbers")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/check-even-odd")
    public String checkEvenOdd(@RequestParam String number) {
        return numberService.checkEvenOdd(number);
    }

}
