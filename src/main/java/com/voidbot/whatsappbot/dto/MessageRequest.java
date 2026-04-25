package com.voidbot.whatsappbot.dto;

public class MessageRequest {

    private String sender;
    private String message;

    public MessageRequest() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}