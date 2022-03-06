package com.company;

import com.company.model.CheckNumber;
import java.io.IOException;

/*
Приложение, управляющее балансом абонентов мобильной телефонной сети.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CheckNumber check = new CheckNumber("00375-33-1234567");
        System.out.println(check.isRoaming());
        System.out.println(check.isFixed());
        System.out.println(check.isWithin());
        System.out.println(check.isOther());
    }
}

