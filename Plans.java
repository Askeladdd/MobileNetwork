package com.company.actions;

import com.company.csv.PlansCsv;
import com.company.model.Plans;

import java.io.IOException;
import java.util.Scanner;

public class Plans {
    private String[] actions = {
            "Добавить план",
            "Отобразить все планы",
            "Отобразить план по id"};
    private String[] fields = {"Введите название плана: ",
    };
    private Scanner scanner = new Scanner(System.in);

    private Plans plans = new Plans();

    public PlansActions() {
        //Прочитать из файла всех пользователей
        PlansCsv plansCsv = new PlansCsv(plans);
    }

    public void showMenu() {
        for (int i = 0; i < 4; i++) System.out.println();
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



}