package com.company.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

//Оказанные услуги
public class Call {

    private long id; //Идентификатор
    private static final AtomicInteger count = new AtomicInteger(0); //Счетчик
    private String numFrom; //Кто позвонил
    private String numTo; //Куда позвонил
    private Date dateBegin; //Дата и время начала звонка
    private Date dateEnd; //Дата и время окончания звонка
    private String sDateBegin;
    private String sDateEnd;
    private final String pattern = "dd-MM-yyyy hh:mm:ss";

    public Call(String numFrom, String numTo, String sDateBegin, String sDateEnd) {
        id = count.incrementAndGet();
        this.numFrom = numFrom;
        this.numTo = numTo;
        this.sDateBegin = sDateBegin;
        this.sDateEnd = sDateEnd;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            dateBegin = formatter.parse(sDateBegin);
            dateBegin = formatter.parse(sDateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Call(long id, String numFrom, String numTo, String sDateBegin, String sDateEnd) {
        this(numFrom, numTo, sDateBegin, sDateEnd);
        this.id = id;
    }

    public String getNumFrom() {
        return numFrom;
    }

    public String getNumTo() {
        return numTo;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public long getId() {
        return id;
    }

    public String getsDateBegin() {
        return sDateBegin;
    }

    public String getsDateEnd() {
        return sDateEnd;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", numFrom='" + numFrom + '\'' +
                ", numTo='" + numTo + '\'' +
                ", sDateBegin='" + sDateBegin + '\'' +
                ", sDateEnd='" + sDateEnd + '\'' +
                '}';
    }
}
