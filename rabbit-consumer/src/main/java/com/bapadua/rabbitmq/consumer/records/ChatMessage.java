package com.bapadua.rabbitmq.consumer.records;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jdk.jfr.DataAmount;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChatMessage {
    private String session;
    private String text;

    public ChatMessage() {
    }

    public ChatMessage(String session, String text) {
        this.session = session;
        this.text = text;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
