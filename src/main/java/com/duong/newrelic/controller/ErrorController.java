package com.duong.newrelic.controller;

import com.newrelic.api.agent.NewRelic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
public class ErrorController {

    @GetMapping(value = "/ping")
    public String ping() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            NewRelic.addCustomParameter("errorType", "ArithmeticException");
            NewRelic.addCustomParameter("requestId", "req-12345");
            NewRelic.noticeError(e);
        }
        return "pong";
    }

    @GetMapping("/nullpointer")
    public String nullPointer() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            NewRelic.addCustomParameter("errorType", "NullPointerException");
            NewRelic.addCustomParameter("requestId", "req-12345");
            NewRelic.noticeError(e);
        }
        return "NullPointerException occurred!";
    }

    @GetMapping("/custom-param")
    public String addCustomParams() {
        NewRelic.addCustomParameter("errorType", "CustomError");
        NewRelic.addCustomParameter("requestId", "req-12345");

        return "Custom parameters added to the transaction!";
    }

}
