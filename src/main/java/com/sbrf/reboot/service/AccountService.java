package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) { this.accountRepository = accountRepository; }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account) {
        // содержит ли getAllAccountsByClientId account класса Account
        if (this.accountRepository.getAllAccountsByClientId(1L).contains(account)) {
            return true;
        } else {
            return false;
        }
    }
    // 11. return счёт с максимальным балансом
    public Account getMaxAccountBalance(long clientId) {
          return accountRepository.getAllAccountsByClientId(clientId)
                  .stream().
                  max(Comparator.comparing(Account::getBalance))
                  .get();
    }

    // 11. return счета с более поздними датами создания, чем указано во входных параметрах
    public Set getAllAccountsByDateMoreThen(long clientId, LocalDate minusDays) {
        return accountRepository.getAllAccountsByClientId(clientId)
                .stream()
                .filter(acc -> acc.getCreateDate().isEqual(minusDays) || acc.getCreateDate().isAfter(minusDays))
                .collect(Collectors.toSet());
    }
}