package com.voidbot.whatsappbot.dto;

import java.time.LocalDateTime;

public class MessageResponse {

    private String reply;
    private LocalDateTime timestamp;

    public MessageResponse() {
    }

    public MessageResponse(String reply, LocalDateTime timestamp) {
        this.reply = reply;
        this.timestamp = timestamp;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}