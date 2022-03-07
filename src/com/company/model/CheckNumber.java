package com.company.model;

public class CheckNumber{
    private String number; //Номер телефона
    private String country; //Страна
    private String operator; //Оператор
    private boolean isValid; //Является ли номер валидным
    private boolean roaming; //Является ли звонок роумингом
    private boolean within; //Сделан ли звонок внутри сети
    private boolean fixed; //Сделан ли звонок на стационарный номер
    private boolean other; //Сделан ли звонок в сети других мобильных операторов
    private final String regex = "\\d{5}-\\d{2}-\\d{7}";

    public CheckNumber(String number){
        this.number = number;
        check();
    }

    private void check(){
        isValid = number.matches(regex);
        if (!isValid) try {
            throw new CheckNumberException(number);
        } catch (CheckNumberException e) {
            e.printStackTrace();
        }
        //Проверить, является ли номер номером из этой же сети, из другой сети или роумингом
        country = number.substring(0,5);
        operator = number.substring(6,8);
        roaming= !country.equals("00375")?true:false;
        within = operator.equals("55")?true:false;
        fixed = !((operator.equals("25") || operator.equals("29")|| operator.equals("33")|| operator.equals("44"))&&(!within));
        other = !within && !fixed;
    }

    public String getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    public String getOperator() {
        return operator;
    }

    public boolean isValid() {
        return isValid;
    }

    public boolean isRoaming() {
        return roaming;
    }

    public boolean isWithin() {
        return within;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isOther() {
        return other;
    }

}
