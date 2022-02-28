package com.sbrf.reboot.springBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main16 {
    public static void main(String[] args) {
        getClassPathXMLContext();
        getAnnotationConfigContext();
    }

    public static void getClassPathXMLContext(){
        ClassPathXmlApplicationContext xmlContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Client16 client16 = xmlContext.getBean(Client16.class);
        System.out.println("Вывод данных с помощью getClassPathXMLContext");
        System.out.println("Добрый день, " + client16.getName());
        System.out.println("Ваши данные:");
        client16.infoAccount();
        System.out.println();

        xmlContext.close();
    }

    public static void getAnnotationConfigContext(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        System.out.println("Вывод данных с помощью AnnotationConfigApplicationContext");
        Client16 client16 = context.getBean(Client16.class);
        System.out.println("Добрый день, " + client16.getName());
        System.out.println("Ваши данные:");
        client16.infoAccount();

        context.close();
    }
}
