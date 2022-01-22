package com.sbrf.reboot.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AccountF {
    private int balance;
    private String currency;
    private LocalDate dateCreated;
}
