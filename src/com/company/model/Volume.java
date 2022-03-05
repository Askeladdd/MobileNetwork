package com.company.model;

import java.util.concurrent.atomic.AtomicInteger;
/*
Тип передаваемых данных
 */
public class Volume {
    private long id;
    private static final AtomicInteger count = new AtomicInteger(0); //Счетчик
    private String name; //Название: call, SMS, traffic
    private String unit; //Единица измерения: с, мин, Мб, сообщения

    public Volume(String name, String unit) {
        id = count.incrementAndGet();
        this.name = name;
        this.unit = unit;
    }

    public long getId() {
        return id;
    }
}
