package com.company.actions;

import java.util.Scanner;

public class AllActions {
    private String[] actions = {
            "Пользователи",
            "Абоненты",
            "Звонки",
            "Планы",
            "Выход"};
    private Scanner scanner = new Scanner(System.in);
    PersonsActions personsActions = new PersonsActions();
    PlansActions plansActions = new PlansActions();

    public AllActions(){
    }

    public void showMenu() {
        for (int i = 0; i < actions.length; i++)
            System.out.printf("(%d) %s%n", i + 1, actions[i]);
        System.out.println("Ваш выбор: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                personsActions.showMenu();
                showMenu();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                plansActions.showMenu();
                showMenu();
                break;
            case 5:
                exit();
                break;
        }
    }

    public void exit(){
        System.out.println("exit");
    }
}
