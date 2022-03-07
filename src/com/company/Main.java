package com.company;

import com.company.actions.AllActions;
import java.io.IOException;

/*
Приложение, управляющее балансом абонентов мобильной телефонной сети.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AllActions allActions = new AllActions();
        allActions.showMenu();
    }
}

