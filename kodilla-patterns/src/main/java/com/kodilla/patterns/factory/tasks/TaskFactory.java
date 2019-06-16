package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public final AbstractTask createTask(TaskType taskType) {
        switch (taskType) {
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
