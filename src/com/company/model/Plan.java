package com.company.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
Тарифный план
 */
public class Plan {

    private long id; //Идентификатор
    private static final AtomicInteger count = new AtomicInteger(0); //Счетчик
    private String name; //Название плана
    private ArrayList<Volume> volumes = new ArrayList<>(); //Составляющие плана

    public Plan(String name) {
        id = count.incrementAndGet();
        this.name = name;
    }

    public Plan(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public ArrayList<Volume> getVolumes() {
        return volumes;
    }

    public void addVolume(Volume volume){
        volumes.add(volume);
    }

    //Идентификаторы типов данных
    public List getIdsVolumes(){
        return volumes.stream().map(volume->volume.getId()).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", volumes=" + Arrays.toString(volumes.toArray()) +
                '}';
    }

}
