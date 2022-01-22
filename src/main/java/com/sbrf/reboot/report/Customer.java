package com.sbrf.reboot.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Customer {
    private int age;
    private String name;
    private Set<AccountF> account;
}
