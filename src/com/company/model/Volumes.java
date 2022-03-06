package com.company.model;

import java.util.ArrayList;
import java.util.LinkedList;

//Коллекция типов передаваемых данных
public class Volumes {
    private ArrayList<Volume> volumes = new ArrayList<>(); //Список типов
    public ArrayList<Volume> getVolumes() {
        return volumes;
    }

    public void add(Volume volume){
        volumes.add(volume);
    }

    public void remove(Volume volume){
        volumes.remove(volume);
    }

    public Volume getById(long id){
        Volume result = null;
        result = volumes.stream().filter(volume->volume.getId()==id).findFirst().get();
        return result;
    }
}
