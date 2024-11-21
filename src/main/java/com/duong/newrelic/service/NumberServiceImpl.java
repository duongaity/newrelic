package com.duong.newrelic.service;

import com.newrelic.api.agent.Trace;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberServiceImpl implements NumberService {

    @Override
    @Trace
    public String checkEvenOdd(String number) {
        try {
            Random random = new Random();
            int delay = random.nextInt(800) + 200;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int n = Integer.parseInt(number);
        if (n % 2 == 0) {
            return "The number " + n + " is Even.";
        } else {
            return "The number " + n + " is Odd.";
        }
    }

}
