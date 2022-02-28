package com.sbrf.reboot.springBean;
import lombok.Getter;


@Getter
public class Client16 {
    private String name;
    private Account16 account;


    public Client16(String name, Account16 account){
        this.name = name;
        this.account = account;
    }

    public void infoAccount(){
        System.out.println(account.infoAccount16());
    }
}