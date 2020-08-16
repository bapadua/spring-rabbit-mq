package com.demo.bapadua.rabbitmq.producer.amqp.ampq.service;

import com.demo.bapadua.rabbitmq.producer.dto.amqp.ChatMessage;

public interface AmpqService {
    void sendToConsumer(ChatMessage chatMessage);
}
