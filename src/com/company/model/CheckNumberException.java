package com.company.model;

public class CheckNumberException extends Exception{
    String message;

    CheckNumberException(String message) {
        this.message=message;
    }

    public String toString(){
        return ("Неверный формат номера: "+message);
    }
}

