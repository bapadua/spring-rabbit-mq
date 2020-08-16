package com.bapadua.rabbitmq.consumer.amqp.impl;

import com.bapadua.rabbitmq.consumer.amqp.AmpqConsumer;
import com.bapadua.rabbitmq.consumer.records.ChatMessage;
import com.bapadua.rabbitmq.consumer.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.bapadua.rabbitmq.consumer.queues.QueuesConst.DEMO_CHAT_RK;

@Component
public class RabbitMQConsumer implements AmpqConsumer<ChatMessage> {

    private final ConsumerService service;

    public RabbitMQConsumer(ConsumerService service) {
        this.service = service;
    }

    @Override
    @RabbitListener(queues = DEMO_CHAT_RK)
    public void consumer(ChatMessage chatMessage) {
        service.consume(chatMessage);
    }
}
