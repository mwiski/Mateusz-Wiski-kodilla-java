package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK = "DRIVINGTASK";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Buy paint", "White Paint", 2);
            case PAINTINGTASK:
                return new PaintingTask("Paint wall in the kitchen", "white", "Wall in the kitchen");
            case DRIVINGTASK:
                return new DrivingTask("Drive to work", "work", "car");
            default:
                return null;
        }
    }
}
