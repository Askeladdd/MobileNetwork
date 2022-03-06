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
    private long price; //Цена за единицу

    @Override
    public String toString() {
        return "Volume{" +
                "id=" + id  +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Volume(String name, String unit, long price) {
        id = count.incrementAndGet();
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public Volume(long id, String name, String unit, long price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }
}
