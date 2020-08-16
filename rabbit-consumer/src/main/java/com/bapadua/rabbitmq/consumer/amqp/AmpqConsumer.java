package com.bapadua.rabbitmq.consumer.amqp;

public interface AmpqConsumer<T> {
    void consumer(T t);
}
