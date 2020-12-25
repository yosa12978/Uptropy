package com.yosaco.uptropy.services;

import com.yosaco.uptropy.domain.Account;
import com.yosaco.uptropy.exceptions.NotFoundException;
import com.yosaco.uptropy.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createAccount(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return this.accountRepository.save(account);
    }

    public Account getByUsername(String username){
        return this.accountRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }

    public Account getById(Long id){
        return this.accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }
}
