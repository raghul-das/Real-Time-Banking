package com.banking.accountservice.controller;


import com.banking.accountservice.model.Account;
import com.banking.accountservice.repository.AccountRepository;
import com.banking.accountservice.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private AccountRepository accountRepository;

    /*@PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }*/

    @GetMapping("/{id}")
    public Optional<Account> getAccount(@PathVariable Long id) {
        return accountRepository.findById(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        Account saved = accountRepository.save(account);
        kafkaProducerService.sendAccountEvent("New account created: " + saved.getAccountNumber());
        return saved;
    }
}