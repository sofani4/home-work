package com.sbrf.reboot.utils;

import java.util.Comparator;
import java.util.List;

import com.sbrf.reboot.dto.Account;

public class AccountUtils {
    //сортировка коллекции со счетами по полю id(id счета)
    public static void sortedById(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId));
    }

    // сортировка коллекции со счетами по id(id счета) и createDate(дата создания счета)
    public static void sortedByIdDate(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId)
                .thenComparing(Account::getCreateDate));
    }

    // сортировка по трем полям: id(id счета) и createDate(дата создания счета) и balance(баланс счёта)
    public static void sortedByIdDateBalance(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId)
                .thenComparing(Account::getCreateDate)
                .thenComparing(Account::getBalance));
    }
}