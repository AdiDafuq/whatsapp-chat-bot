package com.voidbot.whatsappbot;

import com.voidbot.whatsappbot.dto.MessageRequest;
import com.voidbot.whatsappbot.dto.MessageResponse;
import com.voidbot.whatsappbot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class WebhookController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String home() {
        return "WhatsApp Bot Simulator is running!";
    }

    @PostMapping("/webhook")
    public MessageResponse receiveMessage(@RequestBody MessageRequest request) {

        String reply = messageService.generateReply(
                request.getSender(),
                request.getMessage()
        );

        return new MessageResponse(
                reply,
                LocalDateTime.now()
        );
    }

    @GetMapping("/webhook")
public String verifyWebhook(
        @RequestParam("hub.mode") String mode,
        @RequestParam("hub.verify_token") String token,
        @RequestParam("hub.challenge") String challenge
) {

    String VERIFY_TOKEN = "mySecretToken"; // you choose this

    if ("subscribe".equals(mode) && VERIFY_TOKEN.equals(token)) {
        return challenge;
    } else {
        return "Verification failed";
    }
}
}