package com.company;

import com.company.actions.PersonsActions;
import com.company.model.CheckNumber;
import java.io.IOException;

/*
Приложение, управляющее балансом абонентов мобильной телефонной сети.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PersonsActions personsActions = new PersonsActions();
        personsActions.showMenu();
    }
}

