package com.company.model;

import java.util.LinkedList;

public class Plans {
    private LinkedList<Plan> plans = new LinkedList<>(); //Список планов

    public LinkedList<Plan> getPlans() {
        return plans;
    }
    public void add(Plan plan){
        plans.add(plan);
    }

    public void remove(Plan plan){
        plans.remove(plan);
    }

    public Plan getById(int id){
        Plan result = null;
        result = plans.stream().filter(plan->plan.getId()==id).findFirst().get();
        return result;
    }
}
