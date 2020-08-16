package com.bapadua.rabbitmq.consumer.service.impl;

import com.bapadua.rabbitmq.consumer.records.ChatMessage;
import com.bapadua.rabbitmq.consumer.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @Override
    public void consume(ChatMessage message) {
        log.info("message received \n session: {} \n text: {}", message.getSession(), message.getText());
    }
}
