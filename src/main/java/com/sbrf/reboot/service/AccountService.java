package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;

public class AccountService {
    private AccountRepository accountRepository;

    // конструктор к @BeforeEach
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }
    // метод к @Test void bookExist()
    public boolean isAccountExist(long clientId, Account account) {
        // содержит ли getAllAccountsByClientId account класса Account
        if (this.accountRepository.getAllAccountsByClientId(1L).contains(account)) {
            return true;
        } else {
            return false;
        }
    }
}

