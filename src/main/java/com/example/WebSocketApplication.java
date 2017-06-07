package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableScheduling
public class WebSocketApplication {

	/**
	 * Example of websocket app using spring boot.
     * App runs on port 8080 => application.properties
	 * References => https://spring.io/guides/gs/messaging-stomp-websocket/
     *               https://docs.spring.io/spring/docs/current/spring-framework-reference/html/websocket.html
	 **/
	public static void main(String[] args) {
		SpringApplication.run(WebSocketApplication.class, args);
	}
}
