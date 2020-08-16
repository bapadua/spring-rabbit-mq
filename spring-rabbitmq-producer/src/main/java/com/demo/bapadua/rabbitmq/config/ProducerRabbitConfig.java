package com.demo.bapadua.rabbitmq.config;

import com.demo.bapadua.rabbitmq.queues.QueuesConst;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.demo.bapadua.rabbitmq.queues.QueuesConst.*;

@Configuration
public class ProducerRabbitConfig {

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(DEMO_CHAT_EXC);
    }

    @Bean
    Queue deadLetter() {
        return new Queue(DEMO_CHAT_DLQ);
    }

    @Bean
    Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", DEMO_CHAT_EXC);
        args.put("x-dead-letter-routing-key", DEMO_CHAT_DLQ);
        return new Queue(DEMO_CHAT_RK, true, false, false, args);
    }

    @Bean
    public Binding bindingQueue() {
        return BindingBuilder.bind(queue())
                .to(exchange()).with(DEMO_CHAT_RK);
    }

    @Bean
    public Binding bindingDeadLetter() {
        return BindingBuilder.bind(deadLetter())
                .to(exchange()).with(DEMO_CHAT_DLQ);
    }

}
