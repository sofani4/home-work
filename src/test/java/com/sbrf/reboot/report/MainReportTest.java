package com.sbrf.reboot.report;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainReportTest {
    @Test
    void getTotalsWithCompletableFutureTest() throws ExecutionException, InterruptedException {
        Set<AccountF> accountsFillip=new HashSet(){{
            add(new AccountF(3000,"RUB", LocalDate.of(2021, 7, 2)));
            add(new AccountF(1000,"RUB", LocalDate.of(2021, 7, 15)));
            add(new AccountF(1000,"USD", LocalDate.of(2021, 7, 1)));
        }};

        Set<AccountF> accountNikolai=new HashSet(){{
            add(new AccountF(1000,"RUB", LocalDate.of(2021, 7, 5)));
            add(new AccountF(1000,"USD", LocalDate.of(2021, 8, 1)));
        }};

        Set<AccountF> accountAnna=new HashSet(){{
            add(new AccountF(1000,"RUB", LocalDate.of(2021, 7, 6)));
            add(new AccountF(20000,"USD", LocalDate.of(2021, 7, 5)));
        }};

        Set<Customer> accountCustomer = new HashSet() {{
            add(new Customer(18,"Fillip", accountsFillip));
            add(new Customer(17,"Nikolai", accountNikolai));
            add(new Customer(20,"Anna", accountAnna));
        }};
        int sumAllBalance = MainReport.getTotalsWithCompletableFuture(accountCustomer.stream());
        assertEquals(5000, sumAllBalance);
    }
    @Test
    void getTotalsWithReact() throws ExecutionException, InterruptedException {
        Set<AccountF> accountsFillip=new HashSet(){{
            add(new AccountF(3000,"RUB", LocalDate.of(2021, 7, 2)));
            add(new AccountF(1000,"RUB", LocalDate.of(2021, 7, 15)));
            add(new AccountF(1000,"USD", LocalDate.of(2021, 7, 1)));
        }};

        Set<AccountF> accountNikolai=new HashSet(){{
            add(new AccountF(1000,"RUB", LocalDate.of(2021, 7, 5)));
            add(new AccountF(1000,"USD", LocalDate.of(2021, 8, 1)));
        }};

        Set<AccountF> accountAnna=new HashSet(){{
            add(new AccountF(1000,"RUB", LocalDate.of(2021, 7, 6)));
            add(new AccountF(20000,"USD", LocalDate.of(2021, 7, 5)));
        }};

        Set<Customer> accountCustomer = new HashSet() {{
            add(new Customer(18,"Fillip", accountsFillip));
            add(new Customer(17,"Nikolai", accountNikolai));
            add(new Customer(20,"Anna", accountAnna));
        }};
        int sumAllBalance = MainReport.getTotalsWithReact(accountCustomer.stream());
        assertEquals(5000, sumAllBalance);
    }
}