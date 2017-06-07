package com.example.controller;

import com.example.domain.Greeting;
import com.example.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import static com.example.domain.Topics.TOPIC_GREETINGS;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo(TOPIC_GREETINGS)
    public Greeting greet(HelloMessage msg) throws InterruptedException {
        Thread.sleep(2000);
        return new Greeting("Hello " + msg.getName() + "!");
    }

}
