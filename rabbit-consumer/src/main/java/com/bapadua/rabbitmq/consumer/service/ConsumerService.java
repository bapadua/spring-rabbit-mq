package com.bapadua.rabbitmq.consumer.service;

import com.bapadua.rabbitmq.consumer.records.ChatMessage;

public interface ConsumerService {
    void consume(ChatMessage message);
}
