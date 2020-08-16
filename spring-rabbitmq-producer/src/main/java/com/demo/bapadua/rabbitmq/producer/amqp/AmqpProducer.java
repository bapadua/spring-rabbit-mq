package com.demo.bapadua.rabbitmq.producer.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
