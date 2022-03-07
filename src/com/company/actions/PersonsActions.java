package com.company.actions;

import com.company.csv.PersonsCsv;
import com.company.model.Persons;

import java.io.IOException;
import java.util.Scanner;

public class PersonsActions {
    private String[] actions = {
            "Создать пользователя",
            "Отобразить всех пользователей",
            "Отобразить пользователя по id",
            "Удалить пользователя по id"};
    private String[] fields = {"Введите фамилию: ",
            "Введите имя: ",
            "Введите отчество: ",
            "Введите номер паспорта: ",
            "Введите адрес: "};
    private Scanner scanner = new Scanner(System.in);

    private Persons persons = new Persons();

    public PersonsActions() {
        //Прочитать из файла всех пользователей
        PersonsCsv personsCsv = new PersonsCsv(persons);
    }

    public void showMenu() {
        for (int i = 0; i < 5; i++) System.out.println();
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
                deleteById();
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

    public void deleteById() {
        System.out.println("delete by id");
        System.out.println("Введите id");
        int id = scanner.nextInt();
        System.out.println("id= " + id);
        showMenu();
    }

}
