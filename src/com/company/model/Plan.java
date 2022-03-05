package com.company.model;

import java.util.concurrent.atomic.AtomicInteger;

/*
Тарифный план
 */
public class Plan {

    private long id; //Идентификатор
    private static final AtomicInteger count = new AtomicInteger(0); //Счетчик
    private String name; //Название плана
    private long thisNetwork; //Звонки внутри сети, коп/мин
    private long otherNetwork; //Звонки другим мобильным операторам, коп/мин
    private long fixedNetwork; //Звонки на стационарную сеть, коп/мин
    private long roaming; //Звонки на стационарную сеть, коп/мин
    private long sms; //SMS
    private long smsRoaming; //SMS роуминг
    private long internet; //Интернет

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
