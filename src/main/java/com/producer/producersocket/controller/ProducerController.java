package com.producer.producersocket.controller;

import com.producer.producersocket.domain.UserAudit;
import com.producer.producersocket.domain.dto.MessageDto;
import com.producer.producersocket.repos.UserAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private UserAuditRepository userAuditRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);


    @Autowired
    public ProducerController(UserAuditRepository userAuditRepository) {
        this.userAuditRepository = userAuditRepository;
    }

    @GetMapping("/send-message")
    public ResponseEntity<String> sendMessageToUser() {
        logger.info("Sending message to all users");

                UserAudit newUser = new UserAudit();

        MessageDto messageDto = new MessageDto(true, "gold", 123, "Hello World", newUser.getUserId());

        messagingTemplate.convertAndSend("/topic/messages", messageDto);

        return ResponseEntity.ok("Message sent to all users");
    }


}