package com.demo.bapadua.rabbitmq.api;

import com.demo.bapadua.rabbitmq.producer.amqp.ampq.service.AmpqService;
import com.demo.bapadua.rabbitmq.producer.dto.amqp.ChatMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpApi {

    private final AmpqService service;

    public AmqpApi(AmpqService service) {
        this.service = service;
    }

    @PostMapping("send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendToQueue(@RequestBody ChatMessage message) {
        service.sendToConsumer(message);
    }
}
