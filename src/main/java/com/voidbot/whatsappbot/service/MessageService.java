package com.voidbot.whatsappbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private final Random random = new Random();

    public String generateReply(String sender, String message) {

        // log incoming request
        logger.info("Received message from {}: {}", sender, message);

        // validation moved here (yes, controllers don’t need feelings)
        if (sender == null || sender.trim().isEmpty() ||
            message == null || message.trim().isEmpty()) {

            logger.info("Invalid request from {}: empty sender or message", sender);
            return "Invalid request: sender or message is empty";
        }

        String msg = message.toLowerCase();

        if (msg.contains("hi") || msg.contains("hello")) {

            String[] greetings = {
                "Hey! What’s up?",
                "Hi there! How can I help?",
                "Hello! Need something?"
            };

            String reply = greetings[random.nextInt(greetings.length)];

            logger.info("Reply sent to {}: {}", sender, reply);
            return reply;
        }

        if (msg.contains("help")) {
            String reply = "You can say hi, ask questions, or just chat.";

            logger.info("Reply sent to {}: {}", sender, reply);
            return reply;
        }

        if (msg.contains("what to do") || msg.contains("tell me")) {
            String reply = "Try saying 'hi' or ask me something simple. I'm still learning.";

            logger.info("Reply sent to {}: {}", sender, reply);
            return reply;
        }

        String reply = "You said: " + message + ". I’m still learning.";

        logger.info("Reply sent to {}: {}", sender, reply);
        return reply;
    }
}