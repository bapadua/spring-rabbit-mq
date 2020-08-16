package com.demo.bapadua.rabbitmq.producer.dto.amqp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record ChatMessage (
        String session,
        String text
) implements Serializable {
    public ChatMessage {
        Objects.requireNonNull(session);
        Objects.requireNonNull(text);
    }

    public String session() {
        return session();
    }
}

