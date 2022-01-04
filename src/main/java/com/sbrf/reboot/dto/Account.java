package com.sbrf.reboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Account {

    private Long id;
    private String number;
    private BigDecimal balance;
    private LocalDate createDate = LocalDate.now();


    public Account(String number) {
        this.number = number;
    }

    public Account(Long id, String number) {
        this.id = id;
        this.number = number;
    }
}
