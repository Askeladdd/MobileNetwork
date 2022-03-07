package com.company.actions;

import com.company.csv.SubscribersCsv;
import com.company.model.Subscribers;

import java.io.IOException;
import java.util.Scanner;

public class SubscribersActions {
    private String[] actions = {
            "Добавить абонента",
            "Отобразить всех абонентов",
            "Отобразить абонента по id",
            "Выход"};
    private String[] fields = {"Введите имя абонента: "
    };
    private Scanner scanner = new Scanner(System.in);

    private Subscribers subscribers = new Subscribers();

    public SubscribersActions() {
        //Прочитать из файла всех пользователей
        SubscribersCsv callsCsv = new SubscribersCsv(subscribers);
        try {
            callsCsv.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMenu() {
        for (int i = 0; i < actions.length; i++)
            System.out.printf("(%d) %s%n", i + 1, actions[i]);
        System.out.println("Ваш выбор: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                showAll();
                break;
            case 3:
                showById();
                break;
            case 4:
                exit();
                break;
        }
    }

    public void create() {
        System.out.println("create");
        showMenu();
    }

    public void showAll() {
        System.out.println("show all");
        showMenu();
    }

    public void showById() {
        System.out.println("show by id");
        System.out.println("Введите id");
        int id = scanner.nextInt();
        System.out.println("id= " + id);
        showMenu();
    }

    public void exit(){
        System.out.println("exit");
    }

}
