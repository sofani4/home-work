package com.sbrf.reboot.service;

import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(Long clientId);
}