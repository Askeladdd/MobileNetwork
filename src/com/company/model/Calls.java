package com.company.model;

import java.util.LinkedList;

public class Calls {
    private LinkedList<Call> calls = new LinkedList<>(); //Список звонков

    public LinkedList<Call> getCalls() {
        return calls;
    }
    public void add(Call call){
        calls.add(call);
    }

    public void remove(Call call){
        calls.remove(call);
    }

    public Call getById(int id){
        Call result = null;
        result = calls.stream().filter(call->call.getId()==id).findFirst().get();
        return result;
    }
}
