package com.sbrf.reboot.springBean;
import lombok.Getter;


@Getter
public class Account16 {
    private int accountId;
    private double balance;
    private String currency;

    public Account16(int accountId, double balance, String currency){
        this.accountId=accountId;
        this.balance=balance;
        this.currency=currency;
    }

    public String infoAccount16(){
        return "Сумма аккаунта " + this.getAccountId()
                + " равна " + this.getBalance() + " " + this.getCurrency();
    }
}