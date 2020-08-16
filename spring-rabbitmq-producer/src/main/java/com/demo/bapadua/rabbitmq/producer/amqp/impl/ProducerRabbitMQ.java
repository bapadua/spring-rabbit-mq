package com.demo.bapadua.rabbitmq.producer.amqp.impl;

import com.demo.bapadua.rabbitmq.producer.amqp.AmqpProducer;
import com.demo.bapadua.rabbitmq.producer.dto.amqp.ChatMessage;
import com.demo.bapadua.rabbitmq.queues.QueuesConst;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.demo.bapadua.rabbitmq.queues.QueuesConst.*;

@Component
public class ProducerRabbitMQ implements AmqpProducer<ChatMessage> {

    private final RabbitTemplate rabbitTemplate;

    public ProducerRabbitMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void producer(ChatMessage chatMessage) {
        try {
            rabbitTemplate.convertAndSend(DEMO_CHAT_EXC, DEMO_CHAT_RK, chatMessage);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
