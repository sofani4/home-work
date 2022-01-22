package com.sbrf.reboot.report;

import java.time.LocalDate;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static java.util.concurrent.CompletableFuture.supplyAsync;

public class MainReport {

    // Клиенты, соответствующие возрасту от 18 до 30 включительно
    private static Set<Customer> getFilteredCustomers(Stream<Customer> customerStream) {
        return customerStream.filter(customer -> customer.getAge() >= 18 && customer.getAge() <= 30)
                .collect(Collectors.toSet());
    }
    // Условие по дате
    private static final Predicate<AccountF> FILTER_CREATE_DATE = (AccountF) ->
            AccountF.getDateCreated().isAfter(LocalDate.of(2021, 7, 1))
                    && AccountF.getDateCreated().isBefore(LocalDate.of(2021, 8, 1));

    // Условие по валюте
    private static final Predicate<AccountF> FILTER_CUR = (AccountF) -> AccountF.getCurrency().equals("RUB");

    // Основной поток CompletableFuture (выборка клиентов)
    static public int getTotalsWithCompletableFuture(Stream<Customer> streamCustomer) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> result = supplyAsync(() -> getFilteredCustomers(streamCustomer))
                .thenCompose(accounts -> getFilteredAccounts(accounts)); // второй поток
        return result.get();
    }

    // Второстепенный поток CompletableFuture (Доп. фильтр клиентов по дате и валюте)
    public static CompletableFuture<Integer> getFilteredAccounts(Set<Customer> customer) {
        return CompletableFuture.supplyAsync(() -> {
            int sumAllBalance = 0;
            for (Customer i : customer) {
                Stream<AccountF> currentAccount = i.getAccount().stream();
                sumAllBalance += currentAccount
                        .filter(FILTER_CREATE_DATE)
                        .filter(FILTER_CUR)
                        .mapToInt(value -> value.getBalance())
                        .sum();
            }
            return sumAllBalance;
        });
    }

    static public int getTotalsWithReact(Stream<Customer> streamCustomer) {
        int sumAllBalance = 0;
        Set<Customer> customers = getFilteredCustomers(streamCustomer);
        for(Customer customer:customers){
            Stream<AccountF> streamAccount = customer.getAccount().stream();
            sumAllBalance += streamAccount
                    .filter(FILTER_CREATE_DATE)
                    .filter(FILTER_CUR)
                    .mapToInt(value -> value.getBalance())
                    .sum();
        }
        return sumAllBalance;
    }
}