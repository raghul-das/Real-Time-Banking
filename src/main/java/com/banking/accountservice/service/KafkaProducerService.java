package com.banking.accountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "account-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendAccountEvent(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}