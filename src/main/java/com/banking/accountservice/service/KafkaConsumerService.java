package com.banking.accountservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "account-events", groupId = "account-group")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("📩 Consumed Message: " + record.value());
    }
}