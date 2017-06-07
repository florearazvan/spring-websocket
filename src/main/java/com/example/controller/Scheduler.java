package com.example.controller;

import com.example.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.example.domain.Topics.TOPIC_GREETINGS;

@Component
public class Scheduler {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public Scheduler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void sendEvents() {
        Greeting greeting = new Greeting("Hello " + UUID.randomUUID().toString());
        messagingTemplate.convertAndSend(TOPIC_GREETINGS, greeting);
    }

}
