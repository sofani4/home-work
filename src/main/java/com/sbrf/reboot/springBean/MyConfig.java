package com.sbrf.reboot.springBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Account16 account(){
        return new Account16(1234, 5435.34, "RUB");
    }

    @Bean
    public Client16 сlient16Bean(){
        return new Client16("Зимин Александр", account());
    }
}