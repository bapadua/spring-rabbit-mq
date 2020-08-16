package com.demo.bapadua.rabbitmq.producer.amqp.ampq.service.impl;

import com.demo.bapadua.rabbitmq.producer.amqp.AmqpProducer;
import com.demo.bapadua.rabbitmq.producer.amqp.ampq.service.AmpqService;
import com.demo.bapadua.rabbitmq.producer.dto.amqp.ChatMessage;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmpqService {

    private final AmqpProducer amqpProducer;

    public RabbitMQServiceImpl(AmqpProducer amqpProducer) {
        this.amqpProducer = amqpProducer;
    }

    @Override
    public void sendToConsumer(ChatMessage chatMessage) {
        try {
            amqpProducer.producer(chatMessage);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }

    }
}
