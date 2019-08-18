package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    public final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Trainee trainee) {
        System.out.println(name + ": new Tasks to check from trainee " + trainee.getName() +
                "\n(Total tasks to check from trainee " + trainee.getName() + " is: " + trainee.getTasks().size() + ")");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
