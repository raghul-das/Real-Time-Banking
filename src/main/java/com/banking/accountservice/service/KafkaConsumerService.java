package com.banking.accountservice.service;

import com.banking.accountservice.model.Account;
import com.banking.accountservice.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AccountRepository accountRepository;

    @KafkaListener(topics = "account-events", groupId = "account-group")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            Account account = objectMapper.readValue(record.value(), Account.class);
            accountRepository.save(account);
            System.out.println("✅ Account saved: " + account);
        } catch (Exception e) {
            System.err.println("❌ Failed to process message: " + e.getMessage());
        }
    }
}